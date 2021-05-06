package com.store.shop.DAO;

import com.store.shop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    void deleteById(Integer id);
    Optional<Product> findById(Integer id);
}
