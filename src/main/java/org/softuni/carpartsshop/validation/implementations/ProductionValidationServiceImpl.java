package org.softuni.carpartsshop.validation.implementations;


import org.softuni.carpartsshop.domain.entites.Product;
import org.softuni.carpartsshop.domain.models.service.CategoryServiceModel;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.validation.ProductValidationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductionValidationServiceImpl implements ProductValidationService {
    @Override
    public boolean isValid(Product product) {
        return product != null;
    }

    @Override
    public boolean isValid(ProductServiceModel product) {
        return product != null
                && areCategoriesValid(product.getCategories());
    }

    private boolean areCategoriesValid(List<CategoryServiceModel> categories) {
        return categories != null && !categories.isEmpty();
    }
}
