package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {


    private String username;

    private String password;

    private String confirmPassword;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String creditCardNumber;

    private MultipartFile image;

    public UserRegisterBindingModel() {
    }

    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.USERNAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.USERNAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull(message = Constant.PASSWORD_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 6, message = Constant.PASSWORD_MUST_BE_ATLEAST_6_CHARACTER_LONG)
    @Length(max = 20, message = Constant.PASSWORD_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull(message = Constant.PASSWORD_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 6, message = Constant.PASSWORD_MUST_BE_ATLEAST_6_CHARACTER_LONG)
    @Length(max = 20, message = Constant.PASSWORD_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.FIRST_NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.LAST_NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.LAST_NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.LAST_NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @NotNull(message = Constant.EMAIL_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.EMAIL_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.EMAIL_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotNull(message = Constant.PHONE_NUMBER_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 6, message = Constant.PHONE_NUMBER_MUST_BE_ATLEAST_6_CHARACTER_LONG)
    @Length(max = 20, message = Constant.PHONE_NUMBER_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 9, message = Constant.CREDIT_CARD_MUST_BE_ATLEAST_9_CHARACTER_LONG)
    @Length(max = 15, message = Constant.CREDIT_CARD_MUST_BE_MAXIMUM_15_CHARACTER_LONG)
    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
