package org.softuni.carpartsshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.entites.Product;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.softuni.carpartsshop.repository.OfferRepository;
import org.softuni.carpartsshop.repository.ProductRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;
	private final ModelMapper modelMapper;
	private final OfferRepository offerRepository;
	private final ValidationUtil validationUtil;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper, OfferRepository offerRepository,
	    ValidationUtil validationUtil) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
		this.modelMapper = modelMapper;
		this.offerRepository = offerRepository;
		this.validationUtil = validationUtil;
	}

	@Override
	public ProductServiceModel addProduct(ProductServiceModel productServiceModel) {
		if (!this.validationUtil.isValid(productServiceModel)) {
			throw new IllegalArgumentException(Constant.TRYING_TO_ADD_INVALID_DATA);
		}

		Product product = this.productRepository.findByName(productServiceModel.getName()).orElse(null);

		if (product != null) {
			throw new IllegalArgumentException(Constant.PRODUCT_ALREADY_EXIST);
		}

		product = this.modelMapper.map(productServiceModel, Product.class);
		product = this.productRepository.save(product);

		return this.modelMapper.map(product, ProductServiceModel.class);
	}

	@Override
	public List<ProductServiceModel> findAllProducts() {
		return this.productRepository.findAll().stream().map(p -> this.modelMapper.map(p, ProductServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public ProductServiceModel findProductById(String id) {
		return this.productRepository.findById(id).map(p -> {
			ProductServiceModel productServiceModel = this.modelMapper.map(p, ProductServiceModel.class);
			this.offerRepository.findByProduct_Id(productServiceModel.getId()).ifPresent(o -> productServiceModel.setDiscountedPrice(o.getPrice()));

			return productServiceModel;
		}).orElseThrow(() -> new NotFoundExceptions(Constant.PRODUCT_WITH_GIVEN_ID_NOT_FOUND));
	}

	@Override
	public ProductServiceModel editProduct(String id, ProductServiceModel productServiceModel) {
		if (!this.validationUtil.isValid(productServiceModel)) {
			throw new IllegalArgumentException(Constant.TRYING_TO_ADD_INVALID_DATA);
		}
		Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundExceptions(Constant.PRODUCT_WITH_GIVEN_ID_NOT_FOUND));

		if (productServiceModel.getImageUrl() == null) {
			productServiceModel.setImageUrl(product.getImageUrl());
		}

		product = this.modelMapper.map(productServiceModel, Product.class);
		product.setCategory(this.modelMapper.map(productServiceModel.getCategory(), Category.class));
		product = this.productRepository.saveAndFlush(product);

		return this.modelMapper.map(product, ProductServiceModel.class);
	}

	@Override
	public void deleteProduct(String id) {
		Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundExceptions(Constant.PRODUCT_WITH_GIVEN_ID_NOT_FOUND));

		try {
			this.productRepository.delete(product);
		} catch (Exception e) {
			System.out.println(e);
			throw new IllegalArgumentException(Constant.SOMETHING_WENT_WRONG_DURRING_DELETING);

		}
	}

	@Override
	public List<ProductServiceModel> findAllByCategory(String categoryId) {
		List<ProductServiceModel> result;

		result = this.productRepository.findAll().stream().filter(product -> product.getCategory().getId().equals(categoryId)).map(product -> this.modelMapper.map(product,
		    ProductServiceModel.class)).collect(Collectors.toList());

		return result;
	}

	@Override
	public int reduceQuantity(ProductServiceModel productServiceModel, int quantity) {
		int result;

		Product product = this.productRepository.findById(productServiceModel.getId()).orElseThrow(() -> new NotFoundExceptions(Constant.PRODUCT_WITH_GIVEN_ID_NOT_FOUND));

		result = product.getQuantity() - quantity;

		if (result >= 0) {
			product.setQuantity(result);
			this.productRepository.save(product);
		}

		return result;
	}

	@Override
	public ProductDetailsViewModel mapServiceToViewModel(ProductServiceModel product) {
		ProductDetailsViewModel viewModel = new ProductDetailsViewModel();

		viewModel.setId(product.getId());
		viewModel.setName(product.getName());
		viewModel.setDescription(product.getDescription());
		viewModel.setPrice(product.getPrice());
		viewModel.setImageUrl(product.getImageUrl());

		return viewModel;
	}
}
