package org.softuni.carpartsshop.domain.models.view;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable {

    private ProductDetailsViewModel product;
    private int quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(ProductDetailsViewModel product) {
        this.product = product;
    }

    public ProductDetailsViewModel getProduct() {
        return this.product;
    }

    public void setProduct(ProductDetailsViewModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
