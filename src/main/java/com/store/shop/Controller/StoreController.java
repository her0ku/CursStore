package com.store.shop.Controller;

import com.store.shop.Entity.Store;
import com.store.shop.Repository.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/addStore")
    public String showAddStore(Model model)
    {
        model.addAttribute("store", new Store());
        return "addStore";
    }

    @PostMapping("/addStore")
    public String addStore(Model model, @ModelAttribute Store store)
    {
        storeService.addStore(store);
        model.addAttribute("store", new Store());
        return "addStore";
    }

    @GetMapping("/allStores")
    public String showAllStores(Model model){
        List<Store> storeList = storeService.showAllStores();
        model.addAttribute("stores", storeList);
        return "allStores";
    }
}
