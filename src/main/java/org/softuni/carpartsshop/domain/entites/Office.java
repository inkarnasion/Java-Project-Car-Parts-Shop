package org.softuni.carpartsshop.domain.entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office extends BaseEntity {

    private String city;
    private String address;
    private String imageUrl;
    private List<Order>orders;

    public Office() {
        this.orders= new ArrayList<>();
    }

    @Column(name = "city",nullable = false)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
@Column(name = "address",nullable = false)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(targetEntity = Order.class,mappedBy = "office")
    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Column(name = "image_url")
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
