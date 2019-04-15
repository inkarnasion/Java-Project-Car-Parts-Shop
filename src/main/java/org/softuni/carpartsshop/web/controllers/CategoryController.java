package org.softuni.carpartsshop.web.controllers;

import org.modelmapper.ModelMapper;

import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.binding.CategoryAddBindingModel;
import org.softuni.carpartsshop.domain.models.service.CategoryServiceModel;
import org.softuni.carpartsshop.domain.models.view.CategoryViewModel;
import org.softuni.carpartsshop.service.CategoryService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(Constant.CATEGORIES_ACTION)
public class CategoryController extends BaseController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(Constant.GET_MAPPING_ADD)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle(Constant.ADD_CATEGORIES)
    public ModelAndView addCategory() {
        return super.view(Constant.ADD_CATEGORY_ACTION);
    }

    @PostMapping(Constant.POST_MAPPING_ADD)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView addCategoryConfirm(@ModelAttribute CategoryAddBindingModel model) {
        this.categoryService.addCategory(this.modelMapper.map(model, CategoryServiceModel.class));

        return super.redirect(Constant.CATEGORY_CONFIRM_ALL);
    }

    @GetMapping(Constant.GET_MAPPING_ALL)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle(Constant.ALL_CATEGORIES)
    public ModelAndView allCategories(ModelAndView modelAndView) {
        modelAndView.addObject(Constant.CATEGORIES_ACTION_ALL,
                this.categoryService.findAllCategories()
                        .stream()
                        .map(c -> this.modelMapper.map(c, CategoryViewModel.class))
                        .collect(Collectors.toList())
        );

        return super.view(Constant.CATEGORY_ADD_CATEGORY, modelAndView);
    }

    @GetMapping(Constant.GET_MAPPING_EDIT_ID)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle(Constant.EDIT_CATEGORY)
    public ModelAndView editCategory(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject(Constant.ADD_OBJECT_MODEL,
                this.modelMapper.map(this.categoryService.findCategoryById(id), CategoryViewModel.class)
        );

        return super.view(Constant.CATEGORY_EDIT_CATEGORY, modelAndView);
    }

    @PostMapping(Constant.POST_MAPPING_EDIT_ID)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView editCategoryConfirm(@PathVariable String id, @ModelAttribute CategoryAddBindingModel model) {
        this.categoryService.editCategory(id, this.modelMapper.map(model, CategoryServiceModel.class));

        return super.redirect(Constant.CATEGORY_CONFIRM_ALL);
    }

    @GetMapping(Constant.GET_MAPPING_DELETE_ID)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle(Constant.DELETE_CATEGORY_ACTION)
    public ModelAndView deleteCategory(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject(Constant.ADD_OBJECT_MODEL,
                this.modelMapper.map(this.categoryService.findCategoryById(id), CategoryViewModel.class)
        );

        return super.view(Constant.CATEGORY_DELETE_CATEGORY, modelAndView);
    }

    @PostMapping(Constant.POST_MAPPING_DELETE_ID)
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView deleteCategoryConfirm(@PathVariable String id) {
        this.categoryService.deleteCategory(id);

        return super.redirect(Constant.CATEGORY_CONFIRM_ALL);
    }

    @GetMapping(Constant.GET_MAPPING_FETCH)
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public List<CategoryViewModel> fetchCategories() {
        return this.categoryService.findAllCategories()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryViewModel.class))
                .collect(Collectors.toList());
    }
}
