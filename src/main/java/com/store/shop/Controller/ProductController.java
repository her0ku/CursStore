package com.store.shop.Controller;

import com.store.shop.Entity.Order;
import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/allProducts")
    public String showAllUserProducts(Model model)
    {
        List<Product> products = productService.showAllProducts();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User findUser = appUserService.findUserName(name);
        if(name.equals("anonymousUser")){
            name = "";
            findUser.setAnonymStatus(true);
            model.addAttribute("name", name);
            model.addAttribute("user", findUser);
        }
        else if (findUser.getRole().equals("ADMIN"))
        {
            findUser.setAnonymStatus(false);
            return "redirect:/admin/adminPanel";
        }
        else if(findUser.getRole().equals("USER")) {
            {
                User user = appUserService.findUserName(name);
                findUser.setAnonymStatus(false);
                model.addAttribute("name", "Профиль: " + user.getFirstName());
                model.addAttribute("user", user);
            }
        }
        model.addAttribute("products", products);
        return "/allProducts";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User findUser = appUserService.findUserName(name);
        if(name.equals("anonymousUser")){
            name = "";
            findUser.setAnonymStatus(true);
            model.addAttribute("name", name);
            model.addAttribute("user", findUser);
        }
        else if(findUser.getRole().equals("USER")) {
            {
                User user = appUserService.findUserName(name);
                findUser.setAnonymStatus(false);
                model.addAttribute("name", "Профиль: " + user.getFirstName());
                model.addAttribute("user", user);
            }
        }
        return "/about";
    }
    @GetMapping("/contacts")
    public String getContacts(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User findUser = appUserService.findUserName(name);
        if(name.equals("anonymousUser")){
            name = "";
            findUser.setAnonymStatus(true);
            model.addAttribute("name", name);
            model.addAttribute("user", findUser);
        }
        else if(findUser.getRole().equals("USER")) {
            {
                User user = appUserService.findUserName(name);
                findUser.setAnonymStatus(false);
                model.addAttribute("name", "Профиль: " + user.getFirstName());
                model.addAttribute("user", user);
            }
        }
        return "/contacts";
    }
}
