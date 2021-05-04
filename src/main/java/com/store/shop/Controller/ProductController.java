package com.store.shop.Controller;

import com.store.shop.Entity.Payment;
import com.store.shop.Entity.Product;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String ShowAddProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String AddProduct(Model model, @ModelAttribute Product product)
    {
        productService.productSave(product);
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @GetMapping("/allProducts")
    public String showAll(Model model)
    {
        model.addAttribute("payment", new Payment());
        List<Product> products = productService.showAllProducts();
        model.addAttribute("products", products);
        return "allProducts";
    }
}
