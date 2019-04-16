package org.softuni.carpartsshop.domain.models.service;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryServiceModel extends BaseServiceModel {

    private String name;

    public CategoryServiceModel() {
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Size(min = 2,max = 20, message = "Name must be at least between 2 and 20 characters long.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
