package com.store.shop.Repository;

import com.store.shop.Entity.Order;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderService {
    void saveOrder(Order order, String name);
    List<Order> findAll(String mail);
}
