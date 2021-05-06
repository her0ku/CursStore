package com.store.shop.Repository;

import com.store.shop.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void productSave(Product product);
    List<Product> showAllProducts();
    void deleteProductById(Integer id);
    Product findProductById(Integer id);
}
