package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;

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
    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
