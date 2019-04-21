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

	@GetMapping(Constant.GET_MAPPING_ALL)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle(Constant.PAGE_TITLE_ALL_ORDER)
	public ModelAndView getAllOrders(ModelAndView modelAndView) {
		List<OrderServiceModel> orderServiceModels = orderService.findAllOrders();
		List<MyOrdersViewModel> myOrdersViewModels = this.orderService.mapServiceToViewModel(orderServiceModels, this.productService);
		modelAndView.addObject(Constant.ADD_OBJECT_ORDERS, myOrdersViewModels);

		return view(Constant.PAGE_VIEW_ALL_ORDERS, modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_SET_SHIP_ID)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView setShipped(@PathVariable String id) {
		this.orderService.setStatus(id, Status.Shipped);

		return super.redirect(Constant.ADD_PATH_ORDERS_ALL );
	}

	@GetMapping(Constant.GET_MAPPING_ALL_DETAILS + "{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle(Constant.PAGE_TITLE_ORDERS_DETAILS)
	public ModelAndView allOrderDetails(@PathVariable String id, ModelAndView modelAndView) {
		MyOrdersViewModel orderViewModel = this.mapper.map(this.orderService.findOrderById(id), MyOrdersViewModel.class);
		modelAndView.addObject(Constant.ADD_OBJECT_ORDER, orderViewModel);

		return super.view(Constant.PAGE_VIEW_ORDER_DETAILS, modelAndView);
	}

	@GetMapping(Constant.GET_MAPPING_MY)
	@PreAuthorize("isAuthenticated()")
	@PageTitle(Constant.PAGE_TITLE_ORDERS_MY )
	public ModelAndView getMyOrders(ModelAndView modelAndView, Principal principal) {
		List<OrderServiceModel> orderServiceModels = orderService.findOrdersByCustomer(principal.getName());
		List<MyOrdersViewModel> myOrdersViewModels = this.orderService.mapServiceToViewModel(orderServiceModels, this.productService);

		modelAndView.addObject(Constant.ADD_OBJECT_ORDERS, myOrdersViewModels);

		return view(Constant.PAGE_VIEW_ORDER_MY_ORDERS, modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_SET_DELIVER_ID)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView setDelivered(@PathVariable String id) {
		this.orderService.setStatus(id, Status.Delivered);

		return super.redirect(Constant.PAGE_VIEW_ORDER_MY );
	}

	@GetMapping(Constant.GET_MAPPING_DETAILS + "{id}")
	@PreAuthorize("isAuthenticated()")
	@PageTitle(Constant.PAGE_TITLE_ORDERS_DETAILS)
	public ModelAndView myOrderDetails(@PathVariable String id, ModelAndView modelAndView) {
		OrderServiceModel o = this.orderService.findOrderById(id);

		MyOrdersViewModel orderViewModel = this.orderService.mapServiceToViewModel(o, this.productService);
		modelAndView.addObject(Constant.ADD_OBJECT_ORDER, orderViewModel);

		return super.view(Constant.PAGE_VIEW_ORDER_DETAILS, modelAndView);
	}

}
