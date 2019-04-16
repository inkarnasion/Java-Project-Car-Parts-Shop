package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryAddBindingModel {

    private String name;

    public CategoryAddBindingModel() {
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 2, message = "Name must be at least 2 characters long.")
    @Length(max = 20, message = "Name must be maximum 20 characters long.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
