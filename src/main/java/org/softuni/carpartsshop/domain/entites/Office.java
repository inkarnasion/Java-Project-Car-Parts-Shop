package org.softuni.carpartsshop.domain.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "offices")
public class Office extends BaseEntity {

	@NotNull
	@Column(name = "city", nullable = false)
	private String city;

	@NotNull
	@Column(name = "address", nullable = false)
	private String address;

	@NotNull
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@NotNull
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "image_url")
	private String imageUrl;

	@OneToMany(targetEntity = Order.class, mappedBy = "office")
	private List<Order> orders;

	public Office() {
		this.orders = new ArrayList<>();
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
