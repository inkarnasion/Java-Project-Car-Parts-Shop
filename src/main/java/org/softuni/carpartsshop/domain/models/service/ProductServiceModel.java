package org.softuni.carpartsshop.domain.models.service;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.entites.Order;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class ProductServiceModel extends BaseServiceModel {

    private String name;
    private String manufacture;
    private String model;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String imageUrl;
    private List<CategoryServiceModel> categories;
    private BigDecimal discountedPrice;


    public ProductServiceModel() {
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
    @NotNull
    @NotEmpty
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<CategoryServiceModel> getCategories() {
        return this.categories;
    }

    public void setCategories(List<CategoryServiceModel> categories) {
        this.categories = categories;
    }
    @NotNull
    @NotEmpty
    @Min(1)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}


