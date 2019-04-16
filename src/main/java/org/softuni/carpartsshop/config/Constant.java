package org.softuni.carpartsshop.config;

import javax.servlet.http.PushBuilder;

public class Constant {


    public static final String FORM_METHOD_POST = "post";
    public static final String FORM_METHOD_PUT = "put";
    public static final String FORM_METHOD_DELETE = "delete";
    public static final String FORM_METHOD = "post";

    //Mapping
    public static final String GET_MAPPING_ADD="/add";
    public static final String POST_MAPPING_ADD="/add";
    public static final String GET_MAPPING_ALL="/all";
    public static final String GET_MAPPING_FETCH="/fetch";
    public static final String GET_MAPPING_EDIT_ID="/edit/{id}";
    public static final String POST_MAPPING_EDIT_ID="/edit/{id}";
    public static final String POST_MAPPING_DELETE_ID="/delete/{id}";
    public static final String GET_MAPPING_DELETE_ID="/delete/{id}";
    // urls
    public static final String INDEX_ACTION = "/";
    public static final String HOME_ACTION = "/home";
    public static final String ABOUT_ACTION = "/about";
    public static final String CONTACT_ACTION = "/contact";
    public static final String DETAIL_ACTION = "/details";
    public static final String ADMIN_SIDEBAR_ACTION = "/admin-sidebar";
    public static final String TOTAL_PRICE = "totalPrice";
    public static final String PROFILE_ACTION = "/users/profile";
    public static final String EDIT_PROFILE_ACTION = "/users/edit-profile/";
    public static final String REGISTER_FORM_ACTION = "/users/register";
    public static final String LOGIN_FORM_ACTION = "/users/login";
    public static final String ADD_EMPLOYEE_ACTION = "/users/add-employee";
    public static final String EDIT_EMPLOYEE_ACTION = "/users/edit-employee/";
    public static final String DELETE_EMPLOYEE_ACTION = "/users/delete-employee/";
    public static final String AlL_EMLOYEES_ACTION = "/users/all-employees";
    public static final String SET_USER_ACTION = "/users/set-user/";
    public static final String SET_MODERATOR_ACTION = "/users/set-moderator/";
    public static final String SET_ADMIN_ACTION = "/users/set-admin/";


    public static final String ADD_OFFICE_ACTION = "/office/add-office";
    public static final String EDIT_OFFICE_ACTION = "/office/edit-office/";
    public static final String DELETE_OFFICE_ACTION = "/office/delete-office/";
    public static final String ALL_OFFICE_ACTION = "/office/all-offices";


    //Cart Controller
    public static final String ADDING_PRODUCT = "/add-product";
    public static final String CART_CART_DETAILS="/cart/cart-details";
    public static final String CART_DETAILS="/cart/details";
    public static final String CHECK_OUT="/checkout";
    public static final String SHOPPING_CART="shopping-cart";
    public static final String REMOVE_PRODUCT="/remove-product";
    public static final String PAGE_NAME_CART_DETAILS = "Cart Details";


    //Categories Controller
    public static final String ALL_CATEGORIES="All Categories";
    public static final String CATEGORIES_ACTION_ALL="categories";
    public static final String CATEGORIES_ACTION="/categories";
    public static final String ADD_CATEGORIES="Add Category";
    public static final String ADD_CATEGORY_ACTION= "category/add-category";
    public static final String CATEGORY_ADD_CATEGORY="category/all-categories";
    public static final String EDIT_CATEGORY= "Edit Category";
    public static final String CATEGORY_EDIT_CATEGORY="category/edit-category";
    public static final String CATEGORY_CONFIRM_ALL="/categories/all";
    public static final String DELETE_CATEGORY_ACTION="Delete Category";
    public static final String CATEGORY_DELETE_CATEGORY="category/delete-category";


    //Error handler controller
    public static final String ERROR_NOT_FOUND= "/errors/error-not-found";
    public static final String GENERAL_ERROR= "/errors/error-general";
    public static final String ADD_OBJECT_MESSAGE= "message";

    //Home controller
    public static final String PAGE_TITLE_INDEX="Index";
    public static final String PAGE_TITLE_HOME= "Home";
    public static final String PAGE_VIEW_NAME_INDEX="index";
    public static final String PAGE_VIEW_NAME_HOME= "home";
    public static final String PAGE_TITLE_ABOUT= "About";
    public static final String PAGE_VIEW_NAME_ABOUT="about";
    public static final String PAGE_TITLE_CONTACT_US="Contact Us";
    public static final String REDIRECT_VIEW_CONTACT="contact";

    //Offices controller
    public static final String ADD_OBJECT_OFFICES="offices";




    public static final String ADD_OBJECT_MODEL="model";


    public static final String LOGOUT_FORM_ACTION = "/logout?login";


    // pages name
    public static final String REGISTER_PAGE = "/register";
    public static final String LOGIN_PAGE = "/login";
    public static final String INDEX_PAGE = "index";
    public static final String HOME_PAGE = "home";
    public static final String ABOUT_PAGE = "about";
    public static final String CONTACT_PAGE = "contact";
    public static final String CART_PAGE = "/cart";
    public static final String ADMIN_SIDEBAR_PAGE = "admin-sidebar";


    public static final String PROFILE_PAGE = "/profile";
    public static final String EDIT_PROFILE_PAGE = "/edit-profile";
    public static final String ADD_OFFICE_PAGE = "/office/add-office";
    public static final String EDIT_OFFICE_PAGE = "/office/edit-office";
    public static final String DELETE_OFFICE_PAGE = "/office/delete-office";
    public static final String ALL_OFFICE_PAGE = "/office/all-offices";


    // Error Massages
    public static final String USERNAME_ERROR_MESSAGE = "Username not found!";
    public static final String PASSWORD_ERROR_MESSAGE = "Incorrect password!";
    public static final String ID_ERROR_MESSAGE = "Incorrect id!";
    public static final String ERROR_MESSAGE = "The searched item not found!";

}
