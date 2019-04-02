package org.softuni.carpartsshop.config;

public class GlobalConstant {
    public static final String FORM_METHOD = "post";
    public static final String FORM_METHOD_EDIT = "put";
    public static final String FORM_METHOD_DELETE = "delete";
    //urls
    public static final String INDEX_ACTION = "/";
    public static final String HOME_ACTION = "/home";
    public static final String USER_ACTION="/users";
    public static final String REGISTER_ACTION= "/register";
    public static final String REGISTER_FORM_ACTION = "/users/register";
    public static final String LOGIN_FORM_ACTION = "/users/login";
    public static final String AlL_USER_ACTION = "/users/all";
    public static final String SET_USER_ACTION = "/users/set-user/";
    public static final String SET_MODERATOR_ACTION = "/users/set-moderator/";
    public static final String SET_ADMIN_ACTION = "/users/set-admin/";

    public static final String AlL_RESERVATION_ACTION = "/reservation/all";
    public static final String LOGOUT_FORM_ACTION = "/logout?login";
    //pages name
    public static final String REGISTER_PAGE = "register";
    public static final String LOGIN_PAGE = "login";
    public static final String ALL_USER_PAGE = "all-users";

    //Error Massages
    public static final String USERNAME_ERROR_MESSAGE = "Username not found!";
    public static final String PASSWORD_ERROR_MESSAGE = "Incorrect password!";
    public static final String ID_ERROR_MESSAGE = "Incorrect id!";
}

