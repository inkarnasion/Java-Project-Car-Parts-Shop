package org.softuni.carpartsshop.domain.models.service;

import javax.validation.constraints.NotNull;

public class ShipmentServiceModel extends BaseServiceModel {

	@NotNull
	private String shipmentAddress;

	private OrderServiceModel order;

	public ShipmentServiceModel() {
	}

	public String getShipmentAddress() {
		return this.shipmentAddress;
	}

	public void setShipmentAddress(String shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}

	public OrderServiceModel getOrder() {
		return order;
	}

	public void setOrder(OrderServiceModel order) {
		this.order = order;
	}
}