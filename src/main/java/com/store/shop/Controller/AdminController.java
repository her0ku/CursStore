package com.store.shop.Controller;

import com.store.shop.App.appOrder;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
    private String uploadPath = System.getProperty("user.home") + "\\images";

    @Autowired
    private ProductService productService;
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

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

    @GetMapping("/admin/editStatus/{email}/{statusCode}")
    public String editStatus(@PathVariable("email") String mail, @PathVariable("statusCode") String code){
        System.out.println(mail);
        System.out.println(code);
        List<Order> orders = orderService.findAll(mail);
        for(Order o : orders){
            o.setStatusOrder(code);
            orderService.saveOrder(o);
        }
        return "redirect:/admin/allOrdersAdmin";
    }

    @GetMapping("/admin/editStatus/{email}")
    public String editStatusOrder(@PathVariable("email") String email, Model model){

        List<String> statusCodes = new ArrayList<>();
        statusCodes.add("Обрабатывается");
        statusCodes.add("Укомплектован");
        statusCodes.add("Ждёт в пункте выдаче");
        statusCodes.add("Отмена");

        List<Order> orders = orderService.findAll(email);
        Integer sum = CountService.countPrice(orders);
        model.addAttribute("sum",sum);
        model.addAttribute("orders", orders);
        model.addAttribute("statusCodes", statusCodes);
        return "/statusOrderAdmin";
    }

    @GetMapping("/admin/adminPanel")
    public String showPanel(Model model)
    {
        return "/adminPanel";
    }

    @GetMapping("/admin/allOrdersAdmin")
    public String showAllOrders(Model model)
    {
        List<User> users = appUserService.findAllUsers();
        List<appOrder> orders = new ArrayList<>();
        for(User u : users){
            if(u.getRole().equals("USER")){
                appOrder orderApp = new appOrder();
                Order orderStatus = new Order();
                orderApp.setFirstName(u.getFirstName());
                orderApp.setEmail(u.getEmail());
                orderApp.setMobile(u.getMobile());
                orderStatus = orderService.findOrderMail(u.getEmail());
                orderApp.setStatusOrder(orderStatus.getStatusOrder());
                orders.add(orderApp);
            }
        }
        model.addAttribute("users", orders);
        return "/allOrdersAdmin";
    }
}
