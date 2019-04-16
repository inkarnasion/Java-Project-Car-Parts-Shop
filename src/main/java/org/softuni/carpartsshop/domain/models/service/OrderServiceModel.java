package org.softuni.carpartsshop.domain.models.service;

import org.softuni.carpartsshop.domain.entites.Office;
import org.softuni.carpartsshop.domain.entites.Shipment;
import org.softuni.carpartsshop.domain.entites.Status;
import org.softuni.carpartsshop.domain.entites.User;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceModel extends BaseServiceModel {

    private String delivery;
    private Integer quantity;
    private String payment;
    private Shipment shipment;
    private Office office;
    private Status status;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private UserServiceModel customer;
    private List<ProductServiceModel> products;

    public OrderServiceModel() {
        products=new ArrayList<>();
    }

    public String getDelivery() {
        return this.delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
    @NotNull
    @Min(1)
    @Max(10)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @NotNull(message = "Payment cannot be null")
    @NotEmpty
    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    @NotNull(message = "Shimpent cannot be null")
    @NotEmpty
    public Shipment getShipment() {
        return this.shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
    @NotNull(message = "Office cannot be null")
    @NotEmpty
    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    @NotNull(message = "Status cannot be null")
    @NotEmpty
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    @NotNull
    @DecimalMin("0.01")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserServiceModel getCustomer() {
        return this.customer;
    }

    public void setCustomer(UserServiceModel customer) {
        this.customer = customer;
    }

    public List<ProductServiceModel> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductServiceModel> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
