package com.store.shop.Controller;

import com.store.shop.Entity.Brand;
import com.store.shop.Repository.BrandService;
import com.store.shop.Repository.BrandServiceImplement;
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
    private BrandService brandService;

    @GetMapping("/addBrand")
    public String showBrand(Model model)
    {
        model.addAttribute("brand", new Brand());
        return "addBrand";
    }

    @PostMapping("/addBrand")
    public String showBrand(Model model, @ModelAttribute Brand brand)
    {
        brandService.addBrand(brand);
        model.addAttribute("brand", new Brand());
        return "addBrand";
    }

    @GetMapping("/allBrands")
    public String AllBrands(Model model){
        List<Brand> brands = brandService.findAllBrands();
        model.addAttribute("brands", brands);
        return "allBrands";
    }
}
