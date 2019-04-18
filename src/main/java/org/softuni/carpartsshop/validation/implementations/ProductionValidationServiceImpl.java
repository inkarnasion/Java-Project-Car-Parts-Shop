package org.softuni.carpartsshop.validation.implementations;

import org.softuni.carpartsshop.domain.entites.Product;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.validation.ProductValidationService;
import org.springframework.stereotype.Component;

@Component
public class ProductionValidationServiceImpl implements ProductValidationService {
	@Override
	public boolean isValid(Product product) {
		return product != null;
	}

	@Override
	public boolean isValid(ProductServiceModel product) {
		return product != null && product.getCategory() != null;
	}
}