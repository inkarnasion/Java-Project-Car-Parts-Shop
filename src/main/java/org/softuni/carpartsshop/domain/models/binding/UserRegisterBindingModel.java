package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
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

    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 2, message = "UserName must be at least 2 characters long.")
    @Length(max = 20, message = "UserName must be maximum 20 characters long.")
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 6, message = "Password must be at least 2 characters long.")
    @Length(max = 20, message = "Password must be maximum 20 characters long.")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 6, message = "Password must be at least 2 characters long.")
    @Length(max = 20, message = "Password must be maximum 20 characters long.")
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 2, message = "FirstName must be at least 2 characters long.")
    @Length(max = 20, message = "FirstName must be maximum 20 characters long.")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 2, message = "LastName must be at least 2 characters long.")
    @Length(max = 20, message = "LastName must be maximum 20 characters long.")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @NotNull(message = "Email cannot be null")
    @NotEmpty
    @Length(min = 2, message = "Email must be at least 2 characters long.")
    @Length(max = 20, message = "Email must be maximum 20 characters long.")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotNull(message = "PhoneNumber cannot be null")
    @NotEmpty
    @Length(min = 6, message = "PhoneNumber must be at least 6 characters long.")
    @Length(max = 20, message = "PhoneNumber must be maximum 20 characters long.")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 9, message = "CreditCardNumber must be at least 9 characters long.")
    @Length(max = 15, message = "CreditCardNumber must be maximum 15 characters long.")
    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    @NotNull
    @NotEmpty
    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
