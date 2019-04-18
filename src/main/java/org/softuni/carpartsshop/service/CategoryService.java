package org.softuni.carpartsshop.service;

import java.util.List;

import org.softuni.carpartsshop.domain.models.service.CategoryServiceModel;
import org.softuni.carpartsshop.domain.models.view.CategoryViewModel;

public interface CategoryService {

	CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel);

	List<CategoryServiceModel> findAllCategories();

	CategoryServiceModel findCategoryById(String id);

	CategoryServiceModel editCategory(String id, CategoryServiceModel categoryServiceModel);

	CategoryServiceModel deleteCategory(String id);

	List<CategoryViewModel> getCategoriesNames();
}
