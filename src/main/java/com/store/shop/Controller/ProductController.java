package com.store.shop.Controller;

import com.store.shop.Entity.Product;
import com.store.shop.Repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class ProductController {


    private String uploadPath = System.getProperty("user.home") + "\\images";

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String ShowAddProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String AddProduct(Model model, @RequestParam("image") MultipartFile file, @RequestParam("name") String name,
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
        productService.productSave(product);
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @GetMapping("/allProductsAdmin")
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
        model.addAttribute("products", products);
        return "allProducts";
    }
}
