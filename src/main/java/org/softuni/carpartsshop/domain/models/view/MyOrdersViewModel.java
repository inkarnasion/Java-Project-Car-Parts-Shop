package org.softuni.carpartsshop.domain.models.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MyOrdersViewModel extends BaseVieweModel {

	private String customer;
	private BigDecimal totalPrice;
	private String status;
	private String delivery;
	private LocalDateTime finishedOn;
	private List<ProductDetailsViewModel> products;

	public MyOrdersViewModel() {
		products = new ArrayList<ProductDetailsViewModel>();
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelivery() {
		return this.delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public LocalDateTime getFinishedOn() {
		return this.finishedOn;
	}

	public void setFinishedOn(LocalDateTime finishedOn) {
		this.finishedOn = finishedOn;
	}

	public List<ProductDetailsViewModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDetailsViewModel> products) {
		this.products = products;
	}
}