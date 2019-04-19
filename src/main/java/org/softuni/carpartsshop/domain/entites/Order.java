package org.softuni.carpartsshop.domain.entites;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@NotNull
	@Column(name = "payment", nullable = false)
	private String payment;

	@OneToOne(targetEntity = Shipment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "shipment_id", referencedColumnName = "id")
	private Shipment shipment;

	@ManyToOne(targetEntity = Office.class)
	@JoinColumn(name = "office_id", referencedColumnName = "id")
	private Office office;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@NotNull
	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private User customer;

	@OneToMany(targetEntity = OrderItem.class, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;


	@Column(name = "finished_on")
	private LocalDateTime finishedOn;

	public Order() {
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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

	public LocalDateTime getFinishedOn() {
		return this.finishedOn;
	}

	public void setFinishedOn(LocalDateTime finishedOn) {
		this.finishedOn = finishedOn;
	}
}
