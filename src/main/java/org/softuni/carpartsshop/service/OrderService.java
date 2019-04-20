package org.softuni.carpartsshop.service;

import java.util.List;

import org.softuni.carpartsshop.domain.entites.Status;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.view.MyOrdersViewModel;

public interface OrderService {

	void createOrder(OrderServiceModel orderServiceModel);

	List<OrderServiceModel> findAllOrders();

	List<OrderServiceModel> findOrdersByCustomer(String username);

	OrderServiceModel findOrderById(String id);

	void setStatus(String orderId, Status status);

	List<MyOrdersViewModel> mapServiceToViewModel(List<OrderServiceModel> orderServices, ProductService productService);

	MyOrdersViewModel mapServiceToViewModel(OrderServiceModel orderService, ProductService productService);
}
