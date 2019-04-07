package org.softuni.carpartsshop.domain.models.binding;

import org.softuni.carpartsshop.domain.entites.Office;
import org.softuni.carpartsshop.domain.entites.Shipment;
import org.softuni.carpartsshop.domain.entites.Status;

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

    public String getDelivery() {
        return this.delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Shipment getShipment() {
        return this.shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
