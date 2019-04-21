package org.softuni.carpartsshop.domain.models.service;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;

import javax.validation.constraints.NotNull;

public class ShipmentServiceModel extends BaseServiceModel {

	@NotNull

	@Length(min = 2, message = Constant.ADDRESSES_MUST_BE_ATLEAST_2_CHARACTER_LONG)
	@Length(max = 100, message = Constant.ADDRESSES_MUST_BE_MAXIMUM_100_CHARACTER_LONG)
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