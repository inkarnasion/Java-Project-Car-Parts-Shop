package org.softuni.carpartsshop.service;

import org.modelmapper.ModelMapper;

import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.entites.Product;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.softuni.carpartsshop.repository.OfferRepository;
import org.softuni.carpartsshop.repository.ProductRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService,
                              ModelMapper modelMapper, OfferRepository offerRepository, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public ProductServiceModel addProduct(ProductServiceModel productServiceModel) {
        if (!this.validationUtil.isValid(productServiceModel)) {
            throw new IllegalArgumentException("Trying to add invalid data!");
        }

        Product product = this.productRepository
                .findByName(productServiceModel.getName())
                .orElse(null);

        if (product != null) {
            throw new IllegalArgumentException("Product already exists");
        }

        product = this.modelMapper.map(productServiceModel, Product.class);
        product = this.productRepository.save(product);

        return this.modelMapper.map(product, ProductServiceModel.class);
    }

    @Override
    public List<ProductServiceModel> findAllProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductServiceModel findProductById(String id) {
        return this.productRepository.findById(id)
                .map(p -> {
                    ProductServiceModel productServiceModel = this.modelMapper.map(p, ProductServiceModel.class);
                    this.offerRepository.findByProduct_Id(productServiceModel.getId())
                            .ifPresent(o -> productServiceModel.setDiscountedPrice(o.getPrice()));

                    return productServiceModel;
                })
                .orElseThrow(() -> new NotFoundExceptions("Product with the given id was not found!"));
    }

    @Override
    public ProductServiceModel editProduct(String id, ProductServiceModel productServiceModel) {
        if (!this.validationUtil.isValid(productServiceModel)) {
            throw new IllegalArgumentException("Trying to add invalid data!");
        }
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundExceptions("Product with the given id was not found!"));

        product.setName(productServiceModel.getName());
        product.setDescription(productServiceModel.getDescription());
        product.setPrice(productServiceModel.getPrice());
        product.setCategories(productServiceModel.getCategories().stream()
                .map(c -> this.modelMapper.map(c, Category.class)).collect(Collectors.toList()));
        product = this.productRepository.saveAndFlush(product);

        return this.modelMapper.map(product, ProductServiceModel.class);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundExceptions("Product with the given id was not found!"));

        try {
            this.productRepository.delete(product);
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalArgumentException("Something get wrong during deletion");

        }
    }


    @Override
    public List<ProductServiceModel> findAllByCategory(String categoryId) {
        List<ProductServiceModel> result;

        result = this.productRepository.findAll()
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class)).collect(Collectors.toList());

        result = this.productRepository.findAll()
                .stream()
                .filter(product -> product.getCategories().stream()
                        .anyMatch(categoryStream -> categoryStream.getId().equals(categoryId)))
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class)).collect(Collectors.toList());

        return result;
    }


}
