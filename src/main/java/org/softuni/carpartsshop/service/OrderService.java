package org.softuni.carpartsshop.service;

import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;


import java.util.List;

public interface OrderService {

    void createOrder(OrderServiceModel orderServiceModel);

    List<OrderServiceModel> findAllOrders();

    List<OrderServiceModel> findOrdersByCustomer(String username);

    OrderServiceModel findOrderById(String id);
}
