package org.softuni.carpartsshop.domain.entites;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private String delivery;
    private Integer quantity;
    private String payment;
    private Shipment shipment;
    private Office office;
    private Status status;
    private BigDecimal price;
    private User user;
    private List<Product> products;


    public Order() {
    }

    @Column(name = "delivery", nullable = false)
    public String getDelivery() {
        return this.delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Column(name = "payment", nullable = false)
    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    referencedColumnName = "id"))
    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @ManyToOne(targetEntity = Shipment.class)
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    public Shipment getShipment() {
        return this.shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    @ManyToOne(targetEntity = Office.class)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
