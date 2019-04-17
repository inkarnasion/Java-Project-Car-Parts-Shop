package org.softuni.carpartsshop.service;

import org.modelmapper.ModelMapper;

import org.softuni.carpartsshop.domain.entites.Category;
import org.softuni.carpartsshop.domain.models.service.CategoryServiceModel;
import org.softuni.carpartsshop.domain.models.view.CategoryViewModel;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.softuni.carpartsshop.repository.CategoryRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            throw new NotFoundExceptions("Trying to add category witch exist!");
        }

        Category category = this.modelMapper.map(categoryServiceModel, Category.class);

        if (category != null) {
            throw new IllegalArgumentException("Category already exists");
        }

        return this.modelMapper.map(this.categoryRepository.saveAndFlush(category), CategoryServiceModel.class);
    }

    @Override
    public List<CategoryServiceModel> findAllCategories() {
        return this.categoryRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryServiceModel findCategoryById(String id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return this.modelMapper.map(category, CategoryServiceModel.class);
    }

    @Override
    public CategoryServiceModel editCategory(String id, CategoryServiceModel categoryServiceModel) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        category.setName(categoryServiceModel.getName());

        return this.modelMapper.map(this.categoryRepository.saveAndFlush(category), CategoryServiceModel.class);
    }

    @Override
    public CategoryServiceModel deleteCategory(String id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        this.categoryRepository.delete(category);

        return this.modelMapper.map(category, CategoryServiceModel.class);
    }
    @Override
    public List<CategoryViewModel> getCategoriesNames() {
        List<CategoryViewModel> result;
        result = findAllCategories().stream().map(o -> this.modelMapper.map(o, CategoryViewModel.class)).collect(Collectors.toList());

        return result;
    }

    @Override
    public List<CategoryServiceModel> getCategoriesByIds(List<String> ids) {

            List<CategoryServiceModel> result = new ArrayList<>();

            for (String id : ids) {

                CategoryServiceModel model = findCategoryById(id);
                result.add(model);
            }

            return result;

    }
}
