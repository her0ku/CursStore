package com.store.shop.DAO;

import com.store.shop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findAllByMail(String mail);
}
