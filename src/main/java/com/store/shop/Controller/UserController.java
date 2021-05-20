package com.store.shop.Controller;

import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private AppUserService appUserService;

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
            appUserService.signUpUser(user);
            List<Product> products = productService.showAllProducts();
            model.addAttribute("products", products);
            return "allProducts";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("user",new User());
        return "Login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user)
    {
        UserDetails userMail = appUserService.loadUserByUsername(user.getEmail());
        User findUser = appUserService.findUserName(user.getEmail());
        System.out.println(findUser.getRole());
        if(userMail != null){
            return "redirect:/allProducts";
        } else
            return "Login";
    }
}
