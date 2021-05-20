package com.store.shop.Controller;

import com.store.shop.Entity.Cart;
import com.store.shop.Entity.Order;
import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.CartService;
import com.store.shop.Repository.OrderService;
import com.store.shop.Repository.ProductService;
import com.store.shop.Service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

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
        Cart cart = new Cart();
        Product product = productService.findProductById(id);
        cart.setMail(name);
        cart.setItemName(product.getName());
        cart.setPrice(product.getPrice());
        cart.setImage(product.getImage());
        cart.setCategory(product.getCategory());
        cartService.saveCart(cart);
        List<Cart> carts = cartService.findAllByMail(name);
        CountService countService = CountService.count(carts);
        model.addAttribute("cart",carts);
        model.addAttribute("sum", countService.getSum());
        model.addAttribute("counter", countService.getItemCount());
        return "cartList";
    }

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

    @RequestMapping("/deleteFromCart/{id}")
    public String deleteFromCart(@PathVariable("id") Integer id, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        cartService.deleteFromCart(id);
        List<Cart> carts = cartService.findAllByMail(name);
        model.addAttribute("cart",carts);
        CountService countService = CountService.count(carts);
        model.addAttribute("sum", countService.getSum());
        model.addAttribute("counter", countService.getItemCount());
        return "cartList";
    }
}
