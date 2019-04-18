package org.softuni.carpartsshop.domain.entites;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shipments")
public class Shipment extends BaseEntity {

	@NotNull
	@Column(name = "shipment_price", nullable = false)
	private BigDecimal shipmentPrice;

	@NotNull
	@Column(name = "shipment_address", nullable = false)
	private String shipmentAddress;

	@OneToMany(targetEntity = Order.class, mappedBy = "shipment")
	private List<Order> orders;

	public Shipment() {
		this.orders = new ArrayList<>();
	}

	public BigDecimal getShipmentPrice() {
		return this.shipmentPrice;
	}

	public void setShipmentPrice(BigDecimal shipmentPrice) {
		this.shipmentPrice = shipmentPrice;
	}

	public String getShipmentAddress() {
		return this.shipmentAddress;
	}

	public void setShipmentAddress(String shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
