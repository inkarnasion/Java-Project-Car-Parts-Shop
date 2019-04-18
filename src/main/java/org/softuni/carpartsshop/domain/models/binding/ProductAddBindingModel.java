package org.softuni.carpartsshop.domain.models.binding;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class ProductAddBindingModel {
	private String name;
	private String manufacture;
	private String model;
	private String description;
	private BigDecimal price;
	private Integer quantity;
	private MultipartFile image;
	private String categoryId;

	public ProductAddBindingModel() {
	}

	@NotNull(message = "Name cannot be null")
	@NotEmpty
	@Length(min = 2, message = "Name must be at least 2 characters long.")
	@Length(max = 20, message = "Name must be maximum 20 characters long.")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = "Name cannot be null")
	@NotEmpty
	@Length(min = 2, message = "Manufacture must be at least 2 characters long.")
	@Length(max = 20, message = "Manufacture must be maximum 20 characters long.")
	public String getManufacture() {
		return this.manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	@NotNull(message = "Name cannot be null")
	@NotEmpty
	@Length(min = 2, message = "Model must be at least 2 characters long.")
	@Length(max = 20, message = "Model must be maximum 20 characters long.")
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@NotNull(message = "Name cannot be null")
	@NotEmpty
	@Length(min = 2, message = "Description must be at least 2 characters long.")
	@Length(max = 100, message = "Description must be maximum 100 characters long.")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	@DecimalMin("0.01")
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public MultipartFile getImage() {
		return this.image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@NotNull
	@Min(1)
	@Max(100)
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
