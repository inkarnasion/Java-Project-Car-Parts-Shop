package org.softuni.carpartsshop.domain.models.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.softuni.carpartsshop.domain.entites.Status;

public class OrderServiceModel extends BaseServiceModel {

	@NotNull
	@Size(min = 2, max = 20)
	private String payment;

	private ShipmentServiceModel shipment;

	private OfficeServiceModel office;

	@NotNull(message = "Status cannot be null")
	@NotEmpty
	private Status status;

	@NotNull
	@DecimalMin("0.01")
	private BigDecimal totalPrice;

	private UserServiceModel customer;

	private List<OrderItemServiceModel> orderItems;

	public OrderServiceModel() {
		orderItems = new ArrayList<>();
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public ShipmentServiceModel getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentServiceModel shipment) {
		this.shipment = shipment;
	}

	public OfficeServiceModel getOffice() {
		return office;
	}

	public void setOffice(OfficeServiceModel office) {
		this.office = office;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserServiceModel getCustomer() {
		return this.customer;
	}

	public void setCustomer(UserServiceModel customer) {
		this.customer = customer;
	}

	public List<OrderItemServiceModel> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemServiceModel> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
