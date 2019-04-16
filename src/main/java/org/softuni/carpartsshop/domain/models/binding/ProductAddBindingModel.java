package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.entites.Order;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class ProductAddBindingModel {
    private String name;
    private String manufacture;
    private String model;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private MultipartFile image;
    private List<String> categories;
    private List<Order> orders;

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
    @NotNull
    @NotEmpty
    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
}
