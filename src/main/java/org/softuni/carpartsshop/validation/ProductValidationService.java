package org.softuni.carpartsshop.validation;


import org.softuni.carpartsshop.domain.entites.Product;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;

public interface ProductValidationService {
    boolean isValid(Product product);

    boolean isValid(ProductServiceModel product);
}
