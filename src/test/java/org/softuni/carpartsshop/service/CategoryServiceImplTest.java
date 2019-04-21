package org.softuni.carpartsshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.domain.models.service.CategoryServiceModel;
import org.softuni.carpartsshop.repository.CategoryRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.softuni.carpartsshop.utils.ValidationUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CategoryServiceImplTest {

    private ModelMapper modelMapper;
    private ValidationUtil validationUtil;
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void before() {
        this.validationUtil = new ValidationUtilImpl();
        this.modelMapper = new ModelMapper();
        this.categoryService= new CategoryServiceImpl(this.categoryRepository, this.modelMapper, this.validationUtil);
    }

    @Test
    public void addCategory() {

        CategoryServiceModel c = getCategoryServiceModel();

        CategoryServiceModel actualId = this.categoryService.addCategory(c);
        CategoryServiceModel expected = modelMapper.map(categoryService.findCategoryById(actualId.getId()),CategoryServiceModel.class);

        assertEquals(expected.getId(), actualId.getId());
    }
    @Test(expected = Exception.class)
    public void test_registerUser_with_null_data_then_returnExeption() {
        CategoryServiceModel c = getCategoryServiceModelWithNull();
        this.categoryService.addCategory(c);
    }

    @Test
    public void findAllCategories() {

        CategoryServiceModel c = getCategoryServiceModel();

        CategoryServiceModel actualId = this.categoryService.addCategory(c);
        int exprected = this.categoryService.findAllCategories().size();
        assertEquals(1,exprected);
    }

    @Test
    public void findCategoryById() {
        CategoryServiceModel c = getCategoryServiceModel();

        CategoryServiceModel actualId = this.categoryService.addCategory(c);
        CategoryServiceModel expected = modelMapper.map(categoryService.findCategoryById(actualId.getId()),CategoryServiceModel.class);

        assertEquals(expected.getId(), actualId.getId());

    }

    @Test
    public void editCategory() {
        this.addCategory();
        String  mockId = this.categoryService.findAllCategories().stream().findFirst().get().getId();

        CategoryServiceModel editModel = new CategoryServiceModel();
        editModel.setName("NewName");
        this.categoryService.editCategory(mockId,editModel);

        assertEquals("NewName",this.categoryService.findCategoryById(mockId).getName());

    }

    @Test
    public void deleteCategory() {

        CategoryServiceModel c = getCategoryServiceModel();

        CategoryServiceModel actualId = this.categoryService.addCategory(c);
        CategoryServiceModel expected = modelMapper.map(categoryService.deleteCategory(actualId.getId()),CategoryServiceModel.class);

        assertEquals(expected.getId(), actualId.getId());
    }

    @Test
    public void getCategoriesNames() {
    }

    private CategoryServiceModel getCategoryServiceModel(){
        CategoryServiceModel testCategory = new CategoryServiceModel();

        testCategory.setName("Engine");

        return testCategory;
    }
    private CategoryServiceModel getCategoryServiceModelWithNull(){
        CategoryServiceModel testCategory = new CategoryServiceModel();

        testCategory.setName(null);

        return testCategory;
    }
}