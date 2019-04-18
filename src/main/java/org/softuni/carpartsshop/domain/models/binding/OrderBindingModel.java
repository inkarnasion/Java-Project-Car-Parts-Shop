package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.domain.entites.Office;
import org.softuni.carpartsshop.domain.entites.Shipment;
import org.softuni.carpartsshop.domain.entites.Status;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OrderBindingModel {


    private String delivery;
    private Integer quantity;
    private String payment;
    private Shipment shipment;
    private Office office;
    private Status status;
    private BigDecimal price;

    public OrderBindingModel() {
    }
    @NotNull
    @Size(min = 2,max = 20)
    public String getDelivery() {
        return this.delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @NotNull
    @Min(1)
    @Max(100)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @NotEmpty
    @NotNull
    @Size(min = 2,max = 20)
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
}
