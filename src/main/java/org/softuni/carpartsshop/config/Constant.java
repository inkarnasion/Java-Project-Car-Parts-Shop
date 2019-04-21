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

	//Cloud
	public static final String CLOUD_NAME="cloud_name";
	public static final String API_KEY="api_key";
	public static final String API_SECRET="api_secret";

	//Security

	public static final String JS_PATH="/js/**";
	public static final String CSS_PATH="/css/**";
	public static final String STATIC_PATH="/static/**";
	public static final String IMG_PATH="/img/**";
	public static final String TEMPLATES_PATH="/templates/**";
	public static final String VIDEO_PATH="/video/**";
	public static final String ABOUT_PATH="/about";
	public static final String CONTACT_PATH="/contact";
	public static final String USERS_ABOUT_PATH="/users/about";
	public static final String USERNAME_PATH="username";
	public static final String PASSWORD_PATH="password";

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
	public static final String ADD_OBJECT_CATEGORY_NAMES = "categoryNames";

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
	public static final String POST_MAPPING_SET_SHIP_ID = "/set-ship/{id}";
	public static final String POST_MAPPING_SET_DELIVER_ID = "/set-deliver/{id}";


	//Cart Controller
    public static final String ADD_OBJECT_DELIVERY="delivery";
    public static final String ADD_OBJECT_INPUT_OFFICE="inputOffice";
    public static final String ADD_OBJECT_ADDRESS="address";
    public static final String ADD_CONSTANT_OFFICE="Office";
    public static final String ADD_CONSTANT_OFFICE_SELECT="Please select...";
    public static final String ADD_CONSTANT_COURIER="Courier";
    public static final String ADD_CONSTANT_ADDRESS_DELIVERY="Either Office or Delivery Address should be provided";
    public static final String ADD_CONSTANT_PRODUCT="Product ";
    public static final String ADD_CONSTANT_PRODUCT_AVALIBALE=" quantity available is less then requested. Please reduce the ordered quantity with ";


    //Order Controller
	public static final String PAGE_TITLE_ALL_ORDER ="All Orders";

	public static final String SHOP_NAME = "Cart Parts Shop";
	public static final String ADD_OBJECT_TITLE = "title";
	public static final String ADD_OBJECT_FAVICON = "favicon";

	public static final String LOGOUT_FORM_ACTION = "/logout?login";
	public static final String ADD_OBJECT_ORDERS = "orders";
	public static final String ADD_OBJECT_ORDER = "order";
	public static final String ADD_PATH_ORDERS_ALL = "/orders/all";
	public static final String PAGE_TITLE_ORDERS_DETAILS = "Orders Details";

	public static final String PAGE_TITLE_ORDERS_MY = "My Orders";
	public static final String GET_MAPPING_ALL_DETAILS = "/all/details/";
	public static final String PAGE_VIEW_ALL_ORDERS = "order/all-orders";
	public static final String PAGE_VIEW_ORDER_DETAILS = "order/order-details";
	public static final String PAGE_VIEW_ORDER_MY_ORDERS = "/order/my-orders";

	public static final String PAGE_VIEW_ORDER_MY = "/orders/my";
	public static final String GET_MAPPING_MY = "/my";
	public static final String GET_MAPPING_DETAILS = "/details/";


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
	public static final String TRYING_TO_ADD_EXIST_CATEGORY = "Trying to add category witch exist!";
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
	public static final String INVALID_ROLES = "Invalid Roles";
	public static final String NAME_CANNOT_BE_NULL="Name cannot be null";
	public static final String NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG="Name must be at least 2 characters long.";
	public static final String NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG="Name must be maximum 20 characters long.";
	public static final String CITY_NAME_CANNOT_BE_NULL="CityName cannot be null";
	public static final String ADDRESESS_CANNOT_BE_NULL="Address cannot be null";
	public static final String NAME_MUST_BE_MAXIMUM_50_CHARACTER_LONG="Name must be maximum 50 characters long.";
	public static final String PHONE_NUMBER_CANNOT_BE_NULL="PhoneNumber cannot be null";
	public static final String PHONE_NUMBER_MUST_BE_ATLEAST_6_CHARACTER_LONG="PhoneNumber must be at least 6 characters long.";
	public static final String PHONE_NUMBER_MUST_BE_MAXIMUM_20_CHARACTER_LONG="PhoneNumber must be maximum 20 characters long.";
	public static final String EMAIL_CANNOT_BE_NULL="Email cannot be null";
	public static final String EMAIL_MUST_BE_ATLEAST_2_CHARACTER_LONG="Email must be at least 2 characters long.";
	public static final String EMAIL_MUST_BE_MAXIMUM_20_CHARACTER_LONG="Email must be maximum 20 characters long.";
	public static final String STATUS_CANNOT_BE_NULL="Status cannot be null";
	public static final String MANUFACTURE_MUST_BE_ATLEAST_2_CHARACTER_LONG="Manufacture must be at least 2 characters long.";
	public static final String MANUFACTURE_MUST_BE_MAXIMUM_20_CHARACTER_LONG="Manufacture  must be maximum 20 characters long";
	public static final String MODEL_MUST_BE_ATLEAST_2_CHARACTER_LONG="Model must be at least 2 characters long.";
	public static final String MODEL_MUST_BE_MAXIMUM_20_CHARACTER_LONG="Model  must be maximum 20 characters long";
	public static final String DESCRIPTION_MUST_BE_ATLEAST_2_CHARACTER_LONG="Model must be at least 2 characters long.";
	public static final String DESCRIPTION_MUST_BE_MAXIMUM_100_CHARACTER_LONG="Model  must be maximum 100 characters long";
	public static final String USERNAME_MUST_BE_ATLEAST_2_CHARACTER_LONG="UserName must be at least 2 characters long.";
	public static final String USERNAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG="UserName  must be maximum 20 characters long";
	public static final String ADDRESSES_MUST_BE_ATLEAST_2_CHARACTER_LONG="Address must be at least 2 characters long.";
	public static final String ADDRESSES_MUST_BE_MAXIMUM_100_CHARACTER_LONG="Address must be maximum 100 characters long";
	public static final String PASSWORD_MUST_BE_ATLEAST_6_CHARACTER_LONG="Password must be at least 6 characters long.";
	public static final String PASSWORD_MUST_BE_MAXIMUM_20_CHARACTER_LONG="Password must be maximum 20 characters long";
	public static final String FIRST_NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG="FirstName must be at least 2 characters long.";
	public static final String FIRST_NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG="FirstName  must be maximum 20 characters long";
	public static final String LAST_NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG="LastName must be at least 2 characters long.";
	public static final String LAST_NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG="LastName  must be maximum 20 characters long";
	public static final String CREDIT_CARD_MUST_BE_ATLEAST_9_CHARACTER_LONG="CreditCardNumber must be at least 9 characters long.";
	public static final String CREDIT_CARD_MUST_BE_MAXIMUM_15_CHARACTER_LONG="CreditCardNumber  must be maximum 15 characters long";
	public static final String PASSWORD_CANNOT_BE_NULL="Password cannot be null";
	public static final String CATEGORY_NAME="categories";
	public static final String CITY_NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG="CityName must be at least 2 characters long.";
	public static final String CITY_NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG="CityName  must be maximum 20 characters long";
	public static final String ADDRESS_CANNOT_BE_NULL="Address cannot be null";
	public static final String ERROR_NOT_FOUND_EXCEPTION="Not found!";
	public static final String COURIER_ON_ADDRESS="Courier on address: ";
	public static final String TAKE_ORDER_FROM_OFFICE="Take order from office address: " ;
	public static final String TRACE_MESSEGE="A TRACE Message";
	public static final String DEBUG_MESSEGE="A DEBUG Message";
	public static final String INFO_MESSEGE="An INFO Message";
	public static final String WARN_MESSEGE="A WARN Message";
	public static final String AN_ERROR_MESSEGE="An ERROR Message";
	public static final String RETURN_LOG_MESSEGE="Howdy! Check out the Logs to see the output...";
}
