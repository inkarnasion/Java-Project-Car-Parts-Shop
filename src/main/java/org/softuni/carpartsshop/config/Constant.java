package org.softuni.carpartsshop.config;

public class Constant {

	public static final String FORM_METHOD_POST = "post";
	public static final String FORM_METHOD_PUT = "put";
	public static final String FORM_METHOD_DELETE = "delete";
	public static final String FORM_METHOD = "post";
	public static final String FORM_REDIRECT = "redirect:";
	public static final String FORM_FETCH = "/fetch";

	// Mapping
	public static final String GET_MAPPING_ADD = "/add";
	public static final String POST_MAPPING_ADD = "/add";
	public static final String GET_MAPPING_ALL = "/all";
	public static final String GET_MAPPING_FETCH = "/fetch";
	public static final String GET_MAPPING_EDIT_ID = "/edit/{id}";
	public static final String POST_MAPPING_EDIT_ID = "/edit/";
	public static final String POST_MAPPING_DELETE_ID = "/delete/{id}";
	public static final String GET_MAPPING_DELETE_ID = "/delete/{id}";
	// urls
	public static final String ERROR_PAGE_404 = "/errors/404";
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

	// Cart Controller
	public static final String ADDING_PRODUCT = "/add-product";
	public static final String CART_CART_DETAILS = "/cart/cart-details";
	public static final String CART_DETAILS = "/cart/details";
	public static final String CHECK_OUT = "/checkout";
	public static final String SHOPPING_CART = "shopping-cart";
	public static final String REMOVE_PRODUCT = "/remove-product";
	public static final String PAGE_NAME_CART_DETAILS = "Cart Details";
	public static final String CUSTOMER_CREDIT_CARD = "customerCreditCart";
	public static final String ALL_OFFICES = "allOffices";

	// Categories Controller
	public static final String ALL_CATEGORIES = "All Categories";
	public static final String CATEGORIES_ACTION_ALL = "categories";
	public static final String CATEGORIES_ACTION = "/categories";
	public static final String ADD_CATEGORIES = "Add Category";
	public static final String ADD_CATEGORY_ACTION = "category/add-category";
	public static final String CATEGORY_ADD_CATEGORY = "category/all-categories";
	public static final String EDIT_CATEGORY = "Edit Category";
	public static final String CATEGORY_EDIT_CATEGORY = "category/edit-category";
	public static final String CATEGORY_CONFIRM_ALL = "/categories/all";
	public static final String DELETE_CATEGORY_ACTION = "Delete Category";
	public static final String CATEGORY_DELETE_CATEGORY = "category/delete-category";
	public static final String POST_MAPPING_EDIT_CATEGORY_ID = "/edit/{id}";

	// Error handler controller
	// public static final String ERROR_NOT_FOUND= "/errors/error-not-found";
	public static final String ERROR_NOT_FOUND = "/errors/404";
	public static final String ADD_OBJECT_MESSAGE = "message";

	// Home controller
	public static final String PAGE_TITLE_INDEX = "Index";
	public static final String PAGE_TITLE_HOME = "Home";
	public static final String PAGE_VIEW_NAME_INDEX = "index";
	public static final String PAGE_VIEW_NAME_HOME = "home";
	public static final String PAGE_TITLE_ABOUT = "About";
	public static final String PAGE_VIEW_NAME_ABOUT = "about";
	public static final String PAGE_TITLE_CONTACT_US = "Contact Us";
	public static final String REDIRECT_VIEW_CONTACT = "contact";

	// Offer Controller
	public static final String GET_MAPPING_TOP_OFFERS = "/top-offers";
	public static final String PAGE_TITLE_TOP_OFFERS = "Top Offers";
	public static final String OFFERS_TOP_OFFERS = "offer/top-offers";
	public static final String GET_MAPPING_OFFERS_CATEGORY = "/top-offers/{category}";

	// Offices controller
	public static final String ADD_OBJECT_OFFICES = "offices";
	public static final String PAGE_TITLE_OFFICES = "Add Offices";
	public static final String PAGE_TITLE__ALL_OFFICES = "All Offices";
	public static final String PAGE_TITLE__EDIT_OFFICES = "Edit Offices";
	public static final String PAGE_TITLE__DELETE_OFFICES = "Delete Offices";

	// Product Controller
	public static final String PRODUCT_POST_MAPPING_EDIT_ID = "/edit/";
	public static final String PRODUCT_POST_MAPPING_DELETE_ID = "/delete/";
	public static final String PRODUCT_POST_MAPPING_ADD = "/add";
	public static final String REQUEST_MAPING_PRODUCTS = "/products";
	public static final String PRODUCT_ADD_PRODUCT = "product/add-product";
	public static final String PAGE_TITLE_ADD_PRODUCT = "Add Product";
	public static final String VIEW_RPODUCT_ADD_PRODUCT = "product/add-product";
	public static final String REDIRECT_PRODUCT_ALL = "/products/all";
	public static final String PAGE_TITLE_ALL_PRODUCT = "All Products";
	public static final String ADD_OBJECT_PRODUCT = "products";
	public static final String VIEW_PRODUCT_ALL_PRODUCTS = "product/all-products";
	public static final String GET_MAPPING_DETAILS_ID = "/details/{id}";
	public static final String PAGE_TITLE_PRODUCT_DETAILS = "Product Details";
	public static final String ADD_OBJECT_PRODUCTS = "product";
	public static final String VIEW_PRODUCT_DETAILS = "product/details";
	public static final String PAGE_TITLE_EDIT_PRODUCT = "Edit Product";
	public static final String ADD_OBJECT_PRODUCT_ID = "productId";
	public static final String PRODUCT_EDIT_PRODUCT = "/product/edit-product";
	public static final String PAGE_TITLE_DELETE_PRODUCT = "Delete Product";
	public static final String VIEW_PRODUCT_DELETE_PRODUCT = "product/delete-product";
	public static final String PRODUCT_FETCH_CATEGORY_ID = "/fetch/";
	public static final String PRODUCT_ALL = "all";
	public static final String ADD_OBJECT_CATEGORY_NAMES="categoryNames";

	// Users Controller
	public static final String REQUEST_MAPPING_USERS = "/users";
	public static final String PAGE_TITLE_REGISTER = "Register";
	public static final String POST_MAPPING_REGISTER = "/register";
	public static final String VIEW_REGISTER = "register";
	public static final String REDIRECT_LOGIN = "/login";
	public static final String GET_MAPPING_LOGIN = "/login";
	public static final String PAGE_TITLE = "Login";
	public static final String VIEW_LOGIN = "login";
	public static final String PAGE_TITLE_ABOUTH = "About";
	public static final String VIEW_ABOUT = "about";
	public static final String TITLE_PAGE_CONTACT = "Contact";
	public static final String VIEW_CONTACT = "contact";
	public static final String GET_MAPPING_PROFILE = "/profile";
	public static final String ADD_OBJECT_MODEL = "model";
	public static final String VIEW_PROFILE = "profile";
	public static final String PAGE_TITLE_PROFILE = "Profile";
	public static final String GET_MAPPING_EDIT = "/edit";
	public static final String PAGE_TITLE_EDIT_PROFILE = "Edit Profile";
	public static final String VIEW_EDIT_PROFILE = "edit-profile";
	public static final String PATCH_MAPPING_EDIT = "/edit";
	public static final String REDIRECT_USER_PROFILE = "/users/profile";
	public static final String PAGE_TITLE_ALL_USER = "All Users";
	public static final String ADD_OBJECT_USERS = "users";
	public static final String VIEW_ALL_USERS = "all-users";
	public static final String POST_MAPPING_SET_USER_ID = "/set-user/{id}";
	public static final String SET_ROLE_USER = "user";
	public static final String REDIRECT_USERS_ALL = "/users/all";
	public static final String POST_MAPPING_SET_MODERATOR_ID = "/set-moderator/{id}";
	public static final String SET_ROLE_MODERATOR = "moderator";
	public static final String SET_ADMIN_ID = "/set-admin/{id}";
	public static final String SET_ROLE_ADMIN = "admin";
//    public static final String
//    public static final String
//    public static final String

	public static final String SHOP_NAME = "Cart Parts Shop";
	public static final String ADD_OBJECT_TITLE = "title";
	public static final String ADD_OBJECT_FAVICON = "favicon";

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
	public static final String TRYING_TO_ADD_INVALID_DATA = "Trying to add invalid data!";
	public static final String TRYING_TO_ADD_EXIST_CATEGORY="Trying to add category witch exist!";
	public static final String EXIST_USER_IN_DATABASE = "There is a user with this username!";
	public static final String USERNAME_NOT_FOUND = "Username not found!";
	public static final String INCORECT_PASSWORD = "Incorrect password!";
	public static final String INCORECT_ID = "Incorrect id!";
	public static final String PRODUCT_ALREADY_EXIST = "Product already exists";
	public static final String PRODUCT_WITH_GIVEN_ID_NOT_FOUND = "Product with the given id was not found!";
	public static final String SOMETHING_WENT_WRONG_DURRING_DELETING = "Something get wrong during deletion";
	public static final String ORDER_YOU_SELECT_NOT_EXIST = "Order you selected is not exist!";
	public static final String OFFICE_WITH_THIS_DATA_ALREADY_EXIST = "Office already exists";
	public static final String THERE_IS_OFFICE_WITH_SAME_DATA = "There is office with same data!";
	public static final String CREATE_TEMP_FILE = "temp-file";
	public static final String GET_URL = "url";

}
