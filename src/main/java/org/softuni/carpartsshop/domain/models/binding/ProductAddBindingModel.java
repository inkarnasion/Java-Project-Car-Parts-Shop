package org.softuni.carpartsshop.domain.models.binding;

import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.entites.Order;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public class ProductAddBindingModel {
    private String name;
    private String manufacture;
    private String model;
    private String description;
    private BigDecimal price;
    private MultipartFile image;
    private List<String> categories;
    private List<Order> orders;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return this.manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
}
