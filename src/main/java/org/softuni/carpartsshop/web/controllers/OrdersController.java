package org.softuni.carpartsshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.view.MyOrdersViewModel;
import org.softuni.carpartsshop.service.OrderService;
import org.softuni.carpartsshop.service.ProductService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {

    private final ProductService productService;
    private final OrderService orderService;
    private final ModelMapper mapper;

    public OrdersController(
            ProductService productService,
            OrderService orderService,
            ModelMapper modelMapper
    ) {
        this.productService = productService;
        this.orderService = orderService;
        this.mapper = modelMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("All Orders")
    public ModelAndView getAllOrders(ModelAndView modelAndView) {
        List<OrderServiceModel> orderServiceModels = orderService.findAllOrders();
        List<MyOrdersViewModel>myOrdersViewModels= this.orderService.mapServiceToViewModel(orderServiceModels);
        modelAndView.addObject("orders", myOrdersViewModels);

        return view("order/all-orders", modelAndView);
    }

    @GetMapping("/all/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Orders Details")
    public ModelAndView allOrderDetails(@PathVariable String id, ModelAndView modelAndView) {
        MyOrdersViewModel orderViewModel = this.mapper.map(this.orderService.findOrderById(id), MyOrdersViewModel.class);
        modelAndView.addObject("order", orderViewModel);

        return super.view("order/order-details", modelAndView);
    }

    @GetMapping("/my")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("My Orders")
    public ModelAndView getMyOrders(ModelAndView modelAndView, Principal principal) {
        List<OrderServiceModel> orderServiceModels =orderService.findOrdersByCustomer(principal.getName());
        List<MyOrdersViewModel> myOrdersViewModels = this.orderService.mapServiceToViewModel(orderServiceModels);


        modelAndView.addObject("orders", myOrdersViewModels);

        return view("order/my-orders", modelAndView);
    }

    @GetMapping("/my/details/{id}")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Orders Details")
    public ModelAndView myOrderDetails(@PathVariable String id, ModelAndView modelAndView) {
        MyOrdersViewModel orderViewModel = this.mapper.map(this.orderService.findOrderById(id), MyOrdersViewModel.class);
        modelAndView.addObject("order", orderViewModel);

        return super.view("order/order-details", modelAndView);
    }


}
