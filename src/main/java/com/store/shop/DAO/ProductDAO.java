package com.store.shop.DAO;

import com.store.shop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    void deleteById(Integer id);
    Optional<Product> findById(Integer id);
}
