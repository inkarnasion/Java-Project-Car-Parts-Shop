package org.softuni.carpartsshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.service.OrderServiceModel;
import org.softuni.carpartsshop.domain.models.service.ProductServiceModel;
import org.softuni.carpartsshop.domain.models.view.OfficeViewModel;
import org.softuni.carpartsshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.carpartsshop.domain.models.view.ShoppingCartItem;
import org.softuni.carpartsshop.service.OfficeService;
import org.softuni.carpartsshop.service.OrderService;
import org.softuni.carpartsshop.service.ProductService;
import org.softuni.carpartsshop.service.UserService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        ProductDetailsViewModel product = this.modelMapper
                .map(this.productService.findProductById(id), ProductDetailsViewModel.class);

        ShoppingCartItem cartItem = new ShoppingCartItem();
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
        modelAndView.addObject("customerCreditCart", this.userService.findUserByUserName(principal.getName()).getCreditCardNumber());
        modelAndView.addObject("allOffices",this.officeService.allOfficeAddresses(this.officeService.findAllOffices()));
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
    public ModelAndView checkoutConfirm(HttpSession session, Principal principal) {
        var cart = this.retrieveCart(session);

        OrderServiceModel orderServiceModel = this.prepareOrder(cart, principal.getName());
        //SET Payment
        orderServiceModel.setPayment(this.userService.findUserByUserName(principal.getName()).getCreditCardNumber());
        //SET Delivery

        this.orderService.createOrder(orderServiceModel);
        return super.redirect(Constant.HOME_ACTION);
    }

    private List<ShoppingCartItem> retrieveCart(HttpSession session) {
        this.initCart(session);

        return (List<ShoppingCartItem>) session.getAttribute(Constant.SHOPPING_CART);
    }

    private void initCart(HttpSession session) {
        if (session.getAttribute(Constant.SHOPPING_CART) == null) {
            session.setAttribute(Constant.SHOPPING_CART, new LinkedList<>());
        }
    }

    private void addItemToCart(ShoppingCartItem item, List<ShoppingCartItem> cart) {
        for (ShoppingCartItem shoppingCartItem : cart) {
            if (shoppingCartItem.getProduct().getId().equals(item.getProduct().getId())) {
                shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + item.getQuantity());
                return;
            }
        }

        cart.add(item);
    }

    private void removeItemFromCart(String id, List<ShoppingCartItem> cart) {
        cart.removeIf(ci -> ci.getProduct().getId().equals(id));
    }

    private BigDecimal calcTotal(List<ShoppingCartItem> cart) {
        BigDecimal result = new BigDecimal(0);
        for (ShoppingCartItem item : cart) {
            result = result.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
        }

        return result;
    }

    private OrderServiceModel prepareOrder(List<ShoppingCartItem> cart, String customer) {
        OrderServiceModel orderServiceModel = new OrderServiceModel();
        orderServiceModel.setCustomer(this.userService.findUserByUserName(customer));
        List<ProductServiceModel> products = new ArrayList<>();
        for (ShoppingCartItem item : cart) {
            ProductServiceModel productServiceModel = this.modelMapper.map(item.getProduct(), ProductServiceModel.class);

            for (int i = 0; i < item.getQuantity(); i++) {
                products.add(productServiceModel);
            }
        }

        orderServiceModel.setProducts(products);
        orderServiceModel.setTotalPrice(this.calcTotal(cart));

        return orderServiceModel;
    }

    @GetMapping("/fetch")
    @ResponseBody
    public List<OfficeViewModel> fetchOffices() {
        List<OfficeViewModel> result;

        result = this.officeService.findAllOffices().stream()
                .map(o -> this.modelMapper.map(o, OfficeViewModel.class))
                .collect(Collectors.toList());


        return result;
    }


}
