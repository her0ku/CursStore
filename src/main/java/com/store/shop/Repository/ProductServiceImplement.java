package com.store.shop.Repository;

import com.store.shop.DAO.ProductDAO;
import com.store.shop.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService{

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public void productSave(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public List<Product> showAllProducts() {
        return productDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteProductById(Integer id) {
        productDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Product findProductById(Integer id) {
        return productDAO.findById(id).get();
    }
}
