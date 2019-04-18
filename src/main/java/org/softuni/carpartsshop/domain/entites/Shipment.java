package org.softuni.carpartsshop.domain.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shipments")
public class Shipment extends BaseEntity {

	@NotNull
	@Column(name = "shipment_address", nullable = false)
	private String shipmentAddress;

	@OneToOne(targetEntity = Order.class, mappedBy = "shipment", cascade = CascadeType.ALL)
	private Order order;

	public Shipment() {
	}

	public String getShipmentAddress() {
		return this.shipmentAddress;
	}

	public void setShipmentAddress(String shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
