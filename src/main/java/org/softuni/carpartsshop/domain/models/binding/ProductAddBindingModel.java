package org.softuni.carpartsshop.domain.models.binding;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;
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

	@NotNull(message = Constant.NAME_CANNOT_BE_NULL)
	@NotEmpty
	@Length(min = 2, message = Constant.NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
	@Length(max = 20, message = Constant.NAME_MUST_BE_MAXIMUM_50_CHARACTER_LONG)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = Constant.NAME_CANNOT_BE_NULL)
	@NotEmpty
	@Length(min = 2, message = Constant.MANUFACTURE_MUST_BE_ATLEAST_2_CHARACTER_LONG)
	@Length(max = 20, message = Constant.MANUFACTURE_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
	public String getManufacture() {
		return this.manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	@NotNull(message = Constant.NAME_CANNOT_BE_NULL)
	@NotEmpty
	@Length(min = 2, message = Constant.MODEL_MUST_BE_ATLEAST_2_CHARACTER_LONG)
	@Length(max = 20, message = Constant.MODEL_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@NotNull(message = Constant.NAME_CANNOT_BE_NULL)
	@NotEmpty
	@Length(min = 2, message = Constant.DESCRIPTION_MUST_BE_ATLEAST_2_CHARACTER_LONG)
	@Length(max = 100, message = Constant.DESCRIPTION_MUST_BE_MAXIMUM_100_CHARACTER_LONG)
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
