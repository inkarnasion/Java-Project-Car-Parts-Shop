package org.softuni.carpartsshop.domain.models.binding;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.Office;
import org.softuni.carpartsshop.domain.entites.Shipment;
import org.softuni.carpartsshop.domain.entites.Status;

public class OrderBindingModel {

	@NotEmpty
	@NotNull
	@Size(min = 2, max = 20)
	private String payment;

	private Shipment shipment;

	private Office office;

	@NotNull(message = Constant.STATUS_CANNOT_BE_NULL)
	@NotEmpty
	private Status status;

	@NotNull
	@DecimalMin("0.01")
	private BigDecimal totalPrice;

	public OrderBindingModel() {
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Shipment getShipment() {
		return this.shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
