package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OfficeBindingModel {

    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private MultipartFile image;

    public OfficeBindingModel() {
    }
    @NotNull(message = "CityName cannot be null")
    @NotEmpty
    @Length(min = 2, message = "CityName must be at least 2 characters long.")
    @Length(max = 20, message = "CityName must be maximum 20 characters long.")
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @NotNull(message = "Addresses cannot be null")
    @NotEmpty
    @Length(min = 2, message = "Addresses must be at least 2 characters long.")
    @Length(max = 50, message = "Addresses must be maximum 50 characters long.")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
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
}
