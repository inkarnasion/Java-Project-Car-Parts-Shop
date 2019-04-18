package org.softuni.carpartsshop.web.controllers;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.Status;
import org.softuni.carpartsshop.domain.models.service.OrderItemServiceModel;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.service.ShipmentServiceModel;
import org.softuni.carpartsshop.domain.models.service.UserServiceModel;
import org.softuni.carpartsshop.domain.models.view.OfficeViewModel;
import org.softuni.carpartsshop.domain.models.view.OrderItemViewModel;
import org.softuni.carpartsshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.carpartsshop.service.OfficeService;
import org.softuni.carpartsshop.service.OrderService;
import org.softuni.carpartsshop.service.ProductService;
import org.softuni.carpartsshop.service.UserService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(Constant.CART_PAGE)
public class CartController extends BaseController {

	private final ProductService productService;
	private final UserService userService;
	private final OrderService orderService;
	private final ModelMapper modelMapper;
	private final OfficeService officeService;

	@Autowired
	public CartController(ProductService productService, UserService userService, OrderService orderService, ModelMapper modelMapper, OfficeService officeService) {
		this.productService = productService;
		this.userService = userService;
		this.orderService = orderService;
		this.modelMapper = modelMapper;
		this.officeService = officeService;
	}

	@PostMapping(Constant.ADDING_PRODUCT)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView addToCartConfirm(String id, int quantity, HttpSession session) {
		ProductDetailsViewModel product = this.modelMapper.map(this.productService.findProductById(id), ProductDetailsViewModel.class);

		OrderItemViewModel cartItem = new OrderItemViewModel();
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);

		var cart = this.retrieveCart(session);
		this.addItemToCart(cartItem, cart);

		return super.redirect(Constant.HOME_ACTION);
	}

	@GetMapping(Constant.DETAIL_ACTION)
	@PreAuthorize("isAuthenticated()")
	@PageTitle(Constant.PAGE_NAME_CART_DETAILS)
	public ModelAndView cartDetails(ModelAndView modelAndView, HttpSession session, Principal principal, @ModelAttribute(name = "allOffices") OfficeViewModel officeViewModel) {
		var cart = this.retrieveCart(session);
		modelAndView.addObject(Constant.TOTAL_PRICE, this.calcTotal(cart));
		modelAndView.addObject(Constant.CUSTOMER_CREDIT_CARD, this.userService.findUserByUserName(principal.getName()).getCreditCardNumber());
		modelAndView.addObject(Constant.ALL_OFFICES, this.officeService.allOfficeAddresses(this.officeService.findAllOffices()));
		return super.view(Constant.CART_CART_DETAILS, modelAndView);
	}

	@DeleteMapping(Constant.REMOVE_PRODUCT)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView removeFromCartConfirm(String id, HttpSession session) {
		this.removeItemFromCart(id, this.retrieveCart(session));

		return super.redirect(Constant.CART_DETAILS);
	}

	@PostMapping(Constant.CHECK_OUT)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView checkoutConfirm(HttpServletRequest request, HttpSession session, Principal principal) {
		List<OrderItemViewModel> cart = this.retrieveCart(session);
		UserServiceModel user = this.userService.findUserByUserName(principal.getName());

		OrderServiceModel orderServiceModel = new OrderServiceModel();
		orderServiceModel.setPayment(user.getCreditCardNumber());
		List<OrderItemServiceModel> orderItems = cart.stream().map(c -> this.modelMapper.map(c, OrderItemServiceModel.class)).collect(Collectors.toList());
		orderServiceModel.setOrderItems(orderItems);

		for (OrderItemServiceModel orderItemServiceModel : orderItems) {
			orderItemServiceModel.setOrder(orderServiceModel);
		}

		orderServiceModel.setTotalPrice(calcTotal(cart));
		orderServiceModel.setStatus(Status.Pending);
		orderServiceModel.setCustomer(user);

		String officeId = request.getParameter("inputOffice");
		String address = request.getParameter("address");
		if (officeId != null) {
			orderServiceModel.setOffice(this.officeService.findOfficeByID(officeId));
		} else if (address != null && address.length() > 0) {
			ShipmentServiceModel shipment = new ShipmentServiceModel();
			shipment.setShipmentAddress(address);
			orderServiceModel.setShipment(shipment);
			shipment.setOrder(orderServiceModel);
		} else {
			throw new IllegalArgumentException("Either Office or Delivery Address should be provided");
		}

		this.orderService.createOrder(orderServiceModel);

		retrieveCart(session).clear();

		return super.redirect(Constant.HOME_ACTION);
	}

	private List<OrderItemViewModel> retrieveCart(HttpSession session) {
		this.initCart(session);

		return (List<OrderItemViewModel>) session.getAttribute(Constant.SHOPPING_CART);
	}

	private void initCart(HttpSession session) {
		if (session.getAttribute(Constant.SHOPPING_CART) == null) {
			session.setAttribute(Constant.SHOPPING_CART, new LinkedList<>());
		}
	}

	private void addItemToCart(OrderItemViewModel item, List<OrderItemViewModel> cart) {
		for (OrderItemViewModel shoppingCartItem : cart) {
			if (shoppingCartItem.getProduct().getId().equals(item.getProduct().getId())) {
				shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + item.getQuantity());
				return;
			}
		}

		cart.add(item);
	}

	private void removeItemFromCart(String id, List<OrderItemViewModel> cart) {
		cart.removeIf(ci -> ci.getProduct().getId().equals(id));
	}

	private BigDecimal calcTotal(List<OrderItemViewModel> cart) {
		BigDecimal result = new BigDecimal(0);
		for (OrderItemViewModel item : cart) {
			result = result.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
		}

		return result;
	}

	@GetMapping(Constant.FORM_FETCH)
	@ResponseBody
	public List<OfficeViewModel> fetchOffices() {
		List<OfficeViewModel> result;

		result = this.officeService.findAllOffices().stream().map(o -> this.modelMapper.map(o, OfficeViewModel.class)).collect(Collectors.toList());

		return result;
	}
}