package com.store.shop.Repository;

import com.store.shop.Entity.Product;

import java.util.List;

public interface ProductService {
    void productSave(Product product);
    List<Product> showAllProducts();
}
