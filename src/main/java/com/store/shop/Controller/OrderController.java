package com.store.shop.Controller;

import com.store.shop.Entity.Cart;
import com.store.shop.Entity.Order;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.CartService;
import com.store.shop.Repository.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AppUserService appUserService;

    @RequestMapping("/saveOrder")
    public String orderList()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mail = auth.getName();
        User user = appUserService.findUserName(mail);
        List<Cart> carts = cartService.findAllByMail(mail);
        for(Cart c : carts){
            Order order = new Order();
            order.setItemName(c.getItemName());
            order.setUserName(user.getFirstName());
            order.setPrice(c.getPrice());
            order.setTgName(user.getTgName());
            order.setMail(c.getMail());
            order.setStatusOrder("Обрабатывается");
            orderService.saveOrder(order, mail);
        }
        return "redirect:/allProducts";
    }
}
