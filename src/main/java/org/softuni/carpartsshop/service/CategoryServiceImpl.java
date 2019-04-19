package org.softuni.carpartsshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.models.service.CategoryServiceModel;
import org.softuni.carpartsshop.domain.models.view.CategoryViewModel;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.softuni.carpartsshop.repository.CategoryRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;
	private final ValidationUtil validationUtil;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
	}

	@Override
	public CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel) {
		if (!this.validationUtil.isValid(categoryServiceModel)) {
			throw new IllegalArgumentException(Constant.TRYING_TO_ADD_EXIST_CATEGORY);
		}

		Category category = this.modelMapper.map(categoryServiceModel, Category.class);

		if (this.categoryRepository.findByName(category.getName()).orElse(null) != null) {
			throw new IllegalArgumentException(Constant.TRYING_TO_ADD_EXIST_CATEGORY);
		}

		return this.modelMapper.map(this.categoryRepository.saveAndFlush(category), CategoryServiceModel.class);
	}

	@Override
	public List<CategoryServiceModel> findAllCategories() {
		return this.categoryRepository.findAll().stream().map(c -> this.modelMapper.map(c, CategoryServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public CategoryServiceModel findCategoryById(String id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

		return this.modelMapper.map(category, CategoryServiceModel.class);
	}

	@Override
	public CategoryServiceModel editCategory(String id, CategoryServiceModel categoryServiceModel) {
		Category category = this.categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

		category.setName(categoryServiceModel.getName());

		return this.modelMapper.map(this.categoryRepository.saveAndFlush(category), CategoryServiceModel.class);
	}

	@Override
	public CategoryServiceModel deleteCategory(String id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

		this.categoryRepository.delete(category);

		return this.modelMapper.map(category, CategoryServiceModel.class);
	}

	@Override
	public List<CategoryViewModel> getCategoriesNames() {
		List<CategoryViewModel> result;
		result = findAllCategories().stream().map(o -> this.modelMapper.map(o, CategoryViewModel.class)).collect(Collectors.toList());

		return result;
	}
}