package com.store.shop.Repository;

import com.store.shop.Entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    List<Order> findAll(String mail);
}
