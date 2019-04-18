package org.softuni.carpartsshop.domain.models.service;

import javax.validation.constraints.NotNull;

public class OrderItemServiceModel extends BaseServiceModel {

	@NotNull
	private ProductServiceModel product;

	@NotNull
	private int quantity;

	@NotNull
	private OrderServiceModel order;

	public OrderItemServiceModel() {
	}

	public ProductServiceModel getProduct() {
		return product;
	}

	public void setProduct(ProductServiceModel product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderServiceModel getOrder() {
		return order;
	}

	public void setOrder(OrderServiceModel order) {
		this.order = order;
	}
}