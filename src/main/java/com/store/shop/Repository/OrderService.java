package com.store.shop.Repository;

import com.store.shop.Entity.Order;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderService {
    void saveOrder(Order order, String name);
    void saveOrder(Order order);
    List<Order> findAll(String mail);
    Order findOrderMail(String mail);
    void deleteAllOrdersByMail(String mail);
}
