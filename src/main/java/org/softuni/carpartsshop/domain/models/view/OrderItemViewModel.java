package org.softuni.carpartsshop.domain.models.view;

public class OrderItemViewModel extends BaseVieweModel {

	private ProductDetailsViewModel product;
	private int quantity;

	public OrderItemViewModel() {
	}

	public OrderItemViewModel(ProductDetailsViewModel product) {
		this.product = product;
	}

	public ProductDetailsViewModel getProduct() {
		return this.product;
	}

	public void setProduct(ProductDetailsViewModel product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
