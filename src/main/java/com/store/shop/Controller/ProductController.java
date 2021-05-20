package com.store.shop.Controller;

import com.store.shop.App.AppUser;
import com.store.shop.Entity.Product;
import com.store.shop.Entity.User;
import com.store.shop.Repository.AppUserService;
import com.store.shop.Repository.ProductService;
import com.store.shop.Repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {


    private String uploadPath = System.getProperty("user.home") + "\\images";

    @Autowired
    private ProductService productService;
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin/addProduct")
    public String ShowAddProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/admin/addProduct")
    public String AddProduct(@RequestParam("image") MultipartFile file, @RequestParam("name") String name,
                             @RequestParam("price") Integer price, @RequestParam("category") String category,
                             @RequestParam("annotation") String annotation, @RequestParam("Location") String location,
                             @RequestParam("amout") Integer amout) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setAnnotation(annotation);
        product.setAmout(amout);
        product.setCategory(category);
        product.setLocation(location);
        if(!file.isEmpty() && file.getSize() != 0)
        {
            File uploadDir = new File(uploadPath + "\\" + product.getName() + "\\");
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            String result = file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + result));
            product.setImage(result);
        } else {
            product.setImage(product.getImage());
        }
        productService.productSave(product);
        return "redirect:/admin/allProductsAdmin";
    }

    @GetMapping("/admin/allProductsAdmin")
    public String showAll(Model model)
    {
        List<Product> products = productService.showAllProducts();
        model.addAttribute("products", products);
        return "allProductsAdmin";
    }

    @GetMapping("/allProducts")
    public String showAllUserProducts(Model model)
    {
        List<Product> products = productService.showAllProducts();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User findUser = appUserService.findUserName(name);
        if(name.equals("anonymousUser")){
            name = "";
            model.addAttribute("name", name);
        }
        else if (findUser.getRole().equals("ADMIN"))
        {
            return "redirect:/admin/allProductsAdmin";
        }
        else if(findUser.getRole().equals("USER")) {
            {
                User user = appUserService.findUserName(name);
                model.addAttribute("name", "Здравствуй, " + user.getFirstName());
            }
            model.addAttribute("products", products);
            return "allProducts";
        }
        return "/allProducts";
    }

    @RequestMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin/allProductsAdmin";
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView editItem(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("showProductCard");
        Product product = productService.findProductById(id);
        mav.addObject("product", product);
        return mav;
    }

    @PostMapping("/admin/edit/{id}")
    public String AddProduct(@PathVariable("id") Integer id, @RequestParam("name") String name,
            @RequestParam("image") MultipartFile file, @RequestParam("price") Integer price, @RequestParam("category") String category,
                             @RequestParam("annotation") String annotation, @RequestParam("Location") String location,
                             @RequestParam("amout") Integer amout) throws IOException {
        System.out.println("ID - " + id);
        Product product = productService.findProductById(id);

        System.out.println("\nObject - now" + product);
        if(!file.isEmpty())
        {
            File uploadDir = new File(uploadPath + "\\" + product.getName() + "\\");
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            String result = file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + result));
            product.setImage(result);
        }
        product.setName(name);
        product.setPrice(price);
        product.setAnnotation(annotation);
        product.setAmout(amout);
        product.setCategory(category);
        product.setLocation(location);
        System.out.println("\nObject - PAST" + product);
        productService.productSave(product);
        return "redirect:/admin/allProductsAdmin";
    }
}
