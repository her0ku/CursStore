package com.store.shop.Controller;

import com.store.shop.Entity.Payment;
import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.ProductService;
import com.store.shop.Repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/signUp")
    public String addUser(Model model)
    {
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String addUser(Model model, @ModelAttribute User user)
    {
        if(user.getType().equals("buyer"))
        {
            userService.addUser(user);
            List<Product> products = productService.showAllProducts();
            model.addAttribute("products", products);
            return "allProducts";
        }
        else {
            return "signUp";
        }
    }
}
