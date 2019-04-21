package org.softuni.carpartsshop.web.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.binding.ProductAddBindingModel;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.domain.models.view.ProductAllViewModel;
import org.softuni.carpartsshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.carpartsshop.service.CategoryService;
import org.softuni.carpartsshop.service.CloudinaryService;
import org.softuni.carpartsshop.service.ProductService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(Constant.REQUEST_MAPING_PRODUCTS)
public class ProductController extends BaseController {

	private final ProductService productService;
	private final CloudinaryService cloudinaryService;
	private final CategoryService categoryService;
	private final ModelMapper modelMapper;

	@Autowired
	public ProductController(ProductService productService, CloudinaryService cloudinaryService, CategoryService categoryService, ModelMapper modelMapper) {
		this.productService = productService;
		this.cloudinaryService = cloudinaryService;
		this.categoryService = categoryService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(Constant.GET_MAPPING_ADD)
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@PageTitle(Constant.PAGE_TITLE_ADD_PRODUCT)
	public ModelAndView addProduct(ModelAndView modelAndView, @ModelAttribute(name = Constant.ADD_OBJECT_PRODUCTS) ProductAddBindingModel model) {
		modelAndView.addObject(Constant.ADD_OBJECT_CATEGORY_NAMES, this.categoryService.getCategoriesNames());

		return super.view(Constant.PRODUCT_ADD_PRODUCT, modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_ADD)
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@PageTitle(Constant.PAGE_TITLE_ADD_PRODUCT)
	public ModelAndView addProductConfirm(ModelAndView modelAndView, @Valid @ModelAttribute(name = Constant.ADD_OBJECT_PRODUCTS) ProductAddBindingModel model,
	    BindingResult bindingResult) throws IOException {

		if (bindingResult.hasErrors()) {
			return super.view(Constant.VIEW_RPODUCT_ADD_PRODUCT);
		}
		ProductServiceModel productServiceModel = this.modelMapper.map(model, ProductServiceModel.class);

		productServiceModel.setCategory(this.categoryService.findCategoryById(model.getCategoryId()));
		productServiceModel.setImageUrl(this.cloudinaryService.uploadImage(model.getImage()));

		this.productService.addProduct(productServiceModel);

		return super.redirect(Constant.REDIRECT_PRODUCT_ALL);
	}

	@GetMapping(Constant.GET_MAPPING_ALL)
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@PageTitle(Constant.PAGE_TITLE_ALL_PRODUCT)
	public ModelAndView allProducts(ModelAndView modelAndView) {
		Object o = this.productService.findAllProducts().stream().map(p -> this.modelMapper.map(p, ProductAllViewModel.class)).collect(Collectors.toList());

		modelAndView.addObject(Constant.ADD_OBJECT_PRODUCT, o);

		return super.view(Constant.VIEW_PRODUCT_ALL_PRODUCTS, modelAndView);
	}

	@GetMapping(Constant.GET_MAPPING_DETAILS_ID)
	@PreAuthorize("isAuthenticated()")
	@PageTitle(Constant.PAGE_TITLE_PRODUCT_DETAILS)
	public ModelAndView detailsProduct(@PathVariable String id, ModelAndView modelAndView) {
		modelAndView.addObject(Constant.ADD_OBJECT_PRODUCTS, this.modelMapper.map(this.productService.findProductById(id), ProductDetailsViewModel.class));

		return super.view(Constant.VIEW_PRODUCT_DETAILS, modelAndView);
	}

	@GetMapping(Constant.GET_MAPPING_EDIT_ID)
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@PageTitle(Constant.PAGE_TITLE_EDIT_PRODUCT)
	public ModelAndView editProduct(@PathVariable String id, ModelAndView modelAndView) {
		ProductServiceModel productServiceModel = this.productService.findProductById(id);
		ProductAddBindingModel model = this.modelMapper.map(productServiceModel, ProductAddBindingModel.class);

		modelAndView.addObject(Constant.ADD_OBJECT_CATEGORY_NAMES, this.categoryService.getCategoriesNames());
		modelAndView.addObject(Constant.ADD_OBJECT_PRODUCTS, model);
		modelAndView.addObject(Constant.ADD_OBJECT_PRODUCT_ID, id);

		return super.view(Constant.PRODUCT_EDIT_PRODUCT, modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_EDIT_ID + "{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView editProductConfirm(@PathVariable String id, @Valid @ModelAttribute(name = Constant.ADD_OBJECT_PRODUCTS) ProductAddBindingModel model,
	    BindingResult bindingResult, ModelAndView modelAndView) throws IOException {
		ProductServiceModel productServiceModel;

		if (bindingResult.hasErrors()) {
			productServiceModel = this.productService.findProductById(id);
			model = this.modelMapper.map(productServiceModel, ProductAddBindingModel.class);
			modelAndView.addObject(Constant.ADD_OBJECT_CATEGORY_NAMES, this.categoryService.getCategoriesNames());

			return super.view(Constant.PRODUCT_EDIT_PRODUCT, modelAndView);
		}

		productServiceModel = this.modelMapper.map(model, ProductServiceModel.class);
		productServiceModel.setId(id);
		productServiceModel.setCategory(this.categoryService.findCategoryById(model.getCategoryId()));
		if (!model.getImage().isEmpty()) {
			productServiceModel.setImageUrl(this.cloudinaryService.uploadImage(model.getImage()));
		}

		productServiceModel = this.productService.editProduct(id, productServiceModel);

		return super.redirect(Constant.REDIRECT_PRODUCT_ALL);
	}


	@GetMapping(Constant.PRODUCT_POST_MAPPING_DELETE_ID + "{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@PageTitle(Constant.PAGE_TITLE_DELETE_PRODUCT)
	public ModelAndView deleteProduct(@PathVariable String id, ModelAndView modelAndView) {
		ProductServiceModel productServiceModel = this.productService.findProductById(id);
		ProductAddBindingModel model = this.modelMapper.map(productServiceModel, ProductAddBindingModel.class);

		modelAndView.addObject(Constant.ADD_OBJECT_CATEGORY_NAMES, this.categoryService.getCategoriesNames());
		modelAndView.addObject(Constant.ADD_OBJECT_PRODUCTS, model);

		return super.view(Constant.VIEW_PRODUCT_DELETE_PRODUCT, modelAndView);
	}

	@PostMapping(Constant.PRODUCT_POST_MAPPING_DELETE_ID + "{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteProductConfirm(@PathVariable String id) {
		this.productService.deleteProduct(id);

		return super.redirect(Constant.REDIRECT_PRODUCT_ALL);
	}

	@GetMapping(Constant.PRODUCT_FETCH_CATEGORY_ID + "{categoryId}")
	@ResponseBody
	public List<ProductAllViewModel> fetchByCategory(@PathVariable String categoryId) {
		List<ProductAllViewModel> result;

		if (categoryId.equals(Constant.PRODUCT_ALL)) {
			result = this.productService.findAllProducts().stream().map(product -> this.modelMapper.map(product, ProductAllViewModel.class)).collect(Collectors.toList());
		} else {
			result = this.productService.findAllByCategory(categoryId).stream().map(product -> this.modelMapper.map(product, ProductAllViewModel.class)).collect(Collectors.toList());
		}

		return result;
	}

}