package com.store.shop.Repository;

import com.store.shop.DAO.OrderDAO;
import com.store.shop.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplement implements OrderService{
    @Autowired
    private OrderDAO orderDAO;
    @Override
    public void saveOrder(Order order) {
        orderDAO.save(order);
    }
}
