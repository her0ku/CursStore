package com.store.shop.Repository;

import com.store.shop.DAO.ProductDAO;
import com.store.shop.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService{

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void productSave(Product product) {
        productDAO.save(product);
    }

    @Override
    public List<Product> showAllProducts() {
        return productDAO.findAll();
    }
}
