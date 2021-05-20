package com.store.shop.Repository;

import com.store.shop.DAO.OrderDAO;
import com.store.shop.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplement implements OrderService{
    @Autowired
    private OrderDAO orderDAO;
    @Override
    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    @Override
    public List<Order> findAll(String mail) {
        return orderDAO.findAllByMail(mail);
    }

}
