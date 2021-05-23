package com.store.shop.Controller;

import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String addUser(@ModelAttribute User user)
    {
            appUserService.signUpUser(user);
            return "redirect:/Login";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("user",new User());
        return "Login";
    }

    @GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/Login";
    }
}
