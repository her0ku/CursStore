package com.store.shop.Controller;

import com.store.shop.Entity.Brand;
import com.store.shop.Repository.BrandRepositoyImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandContoller {

    @Autowired
    private BrandRepositoyImplement brandRepositoyImplement;

    @GetMapping("/addBrand")
    public String showBrand(Model model)
    {
        model.addAttribute("brand", new Brand());
        return "addBrand";
    }

    @PostMapping("/addBrand")
    public String showBrand(Model model, @ModelAttribute Brand brand)
    {
        brandRepositoyImplement.addBrand(brand);
        model.addAttribute("brand", new Brand());
        return "addBrand";
    }

    @GetMapping("/allBrands")
    public String AllBrands(Model model){
        List<Brand> brands = brandRepositoyImplement.findAllBrands();
        model.addAttribute("brands", brands);
        return "allBrands";
    }
}
