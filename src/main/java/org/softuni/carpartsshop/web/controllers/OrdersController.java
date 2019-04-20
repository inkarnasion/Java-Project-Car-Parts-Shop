package org.softuni.carpartsshop.web.controllers;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.Status;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.view.MyOrdersViewModel;
import org.softuni.carpartsshop.service.OrderService;
import org.softuni.carpartsshop.service.ProductService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {

	private final ProductService productService;
	private final OrderService orderService;
	private final ModelMapper mapper;

	public OrdersController(ProductService productService, OrderService orderService, ModelMapper modelMapper) {
		this.productService = productService;
		this.orderService = orderService;
		this.mapper = modelMapper;
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle("All Orders")
	public ModelAndView getAllOrders(ModelAndView modelAndView) {
		List<OrderServiceModel> orderServiceModels = orderService.findAllOrders();
		List<MyOrdersViewModel> myOrdersViewModels = this.orderService.mapServiceToViewModel(orderServiceModels);
		modelAndView.addObject("orders", myOrdersViewModels);

		return view("order/all-orders", modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_SET_SHIP_ID)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView setShipped(@PathVariable String id) {
		this.orderService.setStatus(id, Status.Shipped);

		return super.redirect("/orders/all");
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
		List<OrderServiceModel> orderServiceModels = orderService.findOrdersByCustomer(principal.getName());
		List<MyOrdersViewModel> myOrdersViewModels = this.orderService.mapServiceToViewModel(orderServiceModels);

		modelAndView.addObject("orders", myOrdersViewModels);

		return view("/order/my-orders", modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_SET_DELIVER_ID)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView setDelivered(@PathVariable String id) {
		this.orderService.setStatus(id, Status.Delivered);

		return super.redirect("/orders/my");
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
