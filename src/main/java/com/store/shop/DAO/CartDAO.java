package com.store.shop.DAO;

import com.store.shop.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByMail(String mail);
    void deleteById(Integer id);
    void deleteByMail(String mail);
}
