package com.store.shop.Controller;

import com.store.shop.Entity.Order;
import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.OrderService;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Integer id, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Product product = productService.findProductById(id);
        System.out.println(product);
        List<Order> orders = orderService.findAll(name);
        System.out.println(orders);
        return "cartList";
    }

    @RequestMapping("/addFromCart/{id}")
    public String orderList(@PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Product product = productService.findProductById(id);
        User user = appUserService.findUserName(name);
        Order order = new Order();
        order.setMail(name);
        order.setUserName(user.getFirstName());
        order.setPrice(product.getPrice());
        order.setItemName(product.getName());
        order.setTgName(user.getTgName());
        order.setStatusOrder("Обрабатывается");
        orderService.saveOrder(order);
        return "redirect:/allProducts";
    }
}
