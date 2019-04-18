package org.softuni.carpartsshop.domain.entites;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	@Column(name = "price")
	private BigDecimal price;

	public Offer() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
