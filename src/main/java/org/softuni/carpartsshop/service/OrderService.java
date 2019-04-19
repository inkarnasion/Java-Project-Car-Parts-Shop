package org.softuni.carpartsshop.service;

import org.softuni.carpartsshop.domain.entites.Order;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.view.MyOrdersViewModel;


import java.util.List;

public interface OrderService {

    void createOrder(OrderServiceModel orderServiceModel);

    List<OrderServiceModel> findAllOrders();

    List<OrderServiceModel> findOrdersByCustomer(String username);

    OrderServiceModel findOrderById(String id);

    List<MyOrdersViewModel> mapServiceToViewModel(List<OrderServiceModel> orderServices);

}
