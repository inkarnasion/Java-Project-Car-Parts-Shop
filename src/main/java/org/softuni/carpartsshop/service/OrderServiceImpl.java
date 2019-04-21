package org.softuni.carpartsshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.Order;
import org.softuni.carpartsshop.domain.entites.Status;
import org.softuni.carpartsshop.domain.entites.User;
import org.softuni.carpartsshop.domain.models.service.OrderItemServiceModel;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.view.MyOrdersViewModel;
import org.softuni.carpartsshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.softuni.carpartsshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class  OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final UserService userService;
	private final ModelMapper modelMapper;

	public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ModelMapper modelMapper) {
		this.orderRepository = orderRepository;

		this.userService = userService;

		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public void createOrder(OrderServiceModel orderServiceModel) {
		Order order = this.modelMapper.map(orderServiceModel, Order.class);

		this.orderRepository.saveAndFlush(order);
	}

	@Override
	public List<OrderServiceModel> findAllOrders() {
		List<Order> orders = this.orderRepository.findAll();
		List<OrderServiceModel> orderServiceModels = orders.stream().map(o -> this.modelMapper.map(o, OrderServiceModel.class)).collect(Collectors.toList());

		return orderServiceModels;
	}

	@Override
	public List<OrderServiceModel> findOrdersByCustomer(String username) {
		User user = this.modelMapper.map(this.userService.findUserByUserName(username), User.class);
		return this.orderRepository.findAllOrdersByCustomer(user).stream().map(o -> modelMapper.map(o, OrderServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public OrderServiceModel findOrderById(String id) {
		return this.orderRepository.findById(id).map(o -> this.modelMapper.map(o, OrderServiceModel.class)).orElseThrow(() -> new NotFoundExceptions(
		    Constant.ORDER_YOU_SELECT_NOT_EXIST));
	}

	@Override
	public List<MyOrdersViewModel> mapServiceToViewModel(List<OrderServiceModel> orderServices, ProductService productService) {
		List<MyOrdersViewModel> result = new ArrayList<>();

		for (OrderServiceModel orderService : orderServices) {
			MyOrdersViewModel viewModel = mapServiceToViewModel(orderService, productService);

			result.add(viewModel);
		}

		return result;
	}

	@Override
	public MyOrdersViewModel mapServiceToViewModel(OrderServiceModel orderService, ProductService productService) {
		MyOrdersViewModel viewModel = new MyOrdersViewModel();

		viewModel.setId(orderService.getId());
		viewModel.setCustomer(orderService.getCustomer().getUsername());
		viewModel.setTotalPrice(orderService.getPrice());
		if (orderService.getOffice() == null) {
			viewModel.setDelivery(Constant.COURIER_ON_ADDRESS + orderService.getShipment().getShipmentAddress());
		} else {
			viewModel.setDelivery(Constant.TAKE_ORDER_FROM_OFFICE + orderService.getOffice().getAddress());
		}
		viewModel.setFinishedOn(orderService.getFinishedOn());
		viewModel.setStatus(orderService.getStatus().toString());

		for (OrderItemServiceModel oi : orderService.getOrderItems()) {
			ProductDetailsViewModel pd = productService.mapServiceToViewModel(oi.getProduct());
			pd.setQuantity(oi.getQuantity());

			viewModel.getProducts().add(pd);
		}

		return viewModel;
	}

	@Override
	public void setStatus(String orderId, Status status) {
		Order order = this.orderRepository.findById(orderId).orElseThrow(() -> new NotFoundExceptions(Constant.ORDER_YOU_SELECT_NOT_EXIST));

		order.setStatus(status);

		this.orderRepository.saveAndFlush(order);
	}
}