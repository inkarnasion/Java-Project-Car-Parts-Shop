package org.softuni.carpartsshop.domain.entites;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@NotNull
	@Column(name = "delivery", nullable = false)
	private String delivery;

	@NotNull
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@NotNull
	@Column(name = "payment", nullable = false)
	private String payment;

	@ManyToOne(targetEntity = Shipment.class)
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
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToMany(targetEntity = Product.class)
	@JoinTable(name = "orders_product", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private List<Product> products;

	public Order() {
	}

	public String getDelivery() {
		return this.delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
}
