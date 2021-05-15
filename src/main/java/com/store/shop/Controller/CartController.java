package com.store.shop.Controller;

import com.store.shop.Entity.Order;
import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.OrderService;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Integer id, Model model)
    {
        Product product = productService.findProductById(id);
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(product);
        Integer sum = 0;
        Integer counter = 0;
        model.addAttribute("cart", listProduct);
        for (Product val : listProduct) {
            sum += val.getPrice();
            counter++;
        }
        model.addAttribute("sum", sum);
        model.addAttribute("counter", counter);
        return "cartList";
    }

    @RequestMapping("/addFromCart/{id}")
    public String orderList(@PathVariable("id") Integer id)
    {
        Product product = productService.findProductById(id);
        Order order = new Order();
        order.setItemName(product.getName());
        order.setPrice(product.getPrice());
        System.out.println(order);
        orderService.saveOrder(order);
        return "redirect:/allProducts";
    }
}
