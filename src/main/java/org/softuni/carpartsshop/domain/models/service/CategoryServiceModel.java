package org.softuni.carpartsshop.domain.models.service;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryServiceModel extends BaseServiceModel {

    private String name;

    public CategoryServiceModel() {
    }
    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
