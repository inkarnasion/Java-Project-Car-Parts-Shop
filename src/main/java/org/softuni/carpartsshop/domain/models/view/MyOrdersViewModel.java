package org.softuni.carpartsshop.domain.models.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class MyOrdersViewModel extends BaseVieweModel {

    private String user;
    private BigDecimal totalPrice;
    private String status;
    private String delivery;
    private LocalDateTime finishedOn;
    private List<ProductDetailsViewModel> productDetailsViewModelList;

    public MyOrdersViewModel() {
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivery() {
        return this.delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public LocalDateTime getFinishedOn() {
        return this.finishedOn;
    }

    public void setFinishedOn(LocalDateTime finishedOn) {
        this.finishedOn = finishedOn;
    }

    public List<ProductDetailsViewModel> getProductDetailsViewModelList() {
        return this.productDetailsViewModelList;
    }

    public void setProductDetailsViewModelList(List<ProductDetailsViewModel> productDetailsViewModelList) {
        this.productDetailsViewModelList = productDetailsViewModelList;
    }
}
