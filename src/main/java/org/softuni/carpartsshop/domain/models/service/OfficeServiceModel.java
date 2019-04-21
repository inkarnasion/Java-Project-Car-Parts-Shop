package org.softuni.carpartsshop.domain.models.service;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OfficeServiceModel extends BaseServiceModel {

    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private String imageUrl;

    public OfficeServiceModel() {
    }
    @NotNull(message = Constant.CITY_NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.CITY_NAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 20, message = Constant.CITY_NAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @NotNull(message = Constant.ADDRESESS_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.ADDRESSES_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 50, message = Constant.NAME_MUST_BE_MAXIMUM_50_CHARACTER_LONG)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @NotNull(message = Constant.PHONE_NUMBER_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 6, message =Constant.PHONE_NUMBER_MUST_BE_ATLEAST_6_CHARACTER_LONG)
    @Length(max = 20, message = Constant.PHONE_NUMBER_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
