package org.softuni.carpartsshop.domain.entites;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shipments")
public class Shipment extends BaseEntity {

    private BigDecimal shipmentPrice;
    private String shipmentAddress;
    private List<Order>orders;

    public Shipment() {
        this.orders=new ArrayList<>();
    }

    @Column(name = "shipment_price",nullable = false)
    public BigDecimal getShipmentPrice() {
        return this.shipmentPrice;
    }

    public void setShipmentPrice(BigDecimal shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }

@Column(name = "shipment_address",nullable = false)
    public String getShipmentAddress() {
        return this.shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }
@OneToMany(targetEntity = Order.class,mappedBy = "shipment")
    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
