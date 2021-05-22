package com.store.shop.Repository;

import com.store.shop.DAO.CartDAO;
import com.store.shop.DAO.OrderDAO;
import com.store.shop.Entity.Order;
import com.store.shop.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class OrderServiceImplement implements OrderService{
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CartDAO cartDAO;

    @Override
    public void saveOrder(Order order, String mail) {
        orderDAO.save(order);
        cartDAO.deleteByMail(mail);
    }
    @Override
    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    @Override
    public List<Order> findAll(String mail) {
        return orderDAO.findAllByMail(mail);
    }

    @Override
    public Order findOrderMail(String mail) {
        return orderDAO.getFirstByMail(mail);
    }

}
