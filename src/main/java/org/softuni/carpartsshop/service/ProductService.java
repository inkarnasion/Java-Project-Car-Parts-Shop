package org.softuni.carpartsshop.service;

import java.util.List;

import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.domain.models.view.ProductDetailsViewModel;

public interface ProductService {

	ProductServiceModel addProduct(ProductServiceModel productServiceModel);

	List<ProductServiceModel> findAllProducts();

	ProductServiceModel findProductById(String id);

	ProductServiceModel editProduct(String id, ProductServiceModel productServiceModel);

	void deleteProduct(String id);

	List<ProductServiceModel> findAllByCategory(String category);

	int reduceQuantity(ProductServiceModel product, int quantity);

	ProductDetailsViewModel mapServiceToViewModel(ProductServiceModel orderService);
}
