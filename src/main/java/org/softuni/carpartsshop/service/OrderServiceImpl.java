package org.softuni.carpartsshop.service;

import org.modelmapper.ModelMapper;

import org.softuni.carpartsshop.domain.entites.Order;
import org.softuni.carpartsshop.domain.entites.User;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.softuni.carpartsshop.repository.OrderRepository;
import org.softuni.carpartsshop.repository.ProductRepository;
import org.softuni.carpartsshop.validation.ProductValidationService;
import org.softuni.carpartsshop.validation.UserValidationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserValidationService userValidation;
    private final ProductValidationService productValidation;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            UserService userService,
            UserValidationService userValidation,
            ProductValidationService productValidation,
            ModelMapper modelMapper
    ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.userValidation = userValidation;
        this.productValidation = productValidation;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void createOrder(OrderServiceModel orderServiceModel) {


        this.orderRepository.saveAndFlush(this.modelMapper.map(orderServiceModel, Order.class));
    }

    @Override
    public List<OrderServiceModel> findAllOrders() {
        List<Order> orders = this.orderRepository.findAll();
        List<OrderServiceModel> orderServiceModels = orders
                .stream()
                .map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());

        return orderServiceModels;
    }

    @Override
    public List<OrderServiceModel> findOrdersByCustomer(String username) {
        User user=this.modelMapper.map(this.userService.findUserByUserName(username),User.class);
        return this.orderRepository.findAllOrdersByUser(user)
                .stream()
                .map(o -> modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderServiceModel findOrderById(String id) {
        return this.orderRepository.findById(id)
                .map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .orElseThrow(() -> new NotFoundExceptions("Order you selected is not exist!"));
    }
}
