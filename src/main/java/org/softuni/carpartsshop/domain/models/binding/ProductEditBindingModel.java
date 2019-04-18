package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class ProductEditBindingModel {
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> categories;

    public ProductEditBindingModel() {
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

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
