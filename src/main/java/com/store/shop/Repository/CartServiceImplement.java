package com.store.shop.Repository;

import com.store.shop.DAO.CartDAO;
import com.store.shop.Entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImplement implements CartService{

    @Autowired
    private CartDAO cartDAO;

    @Override
    public void saveCart(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public List<Cart> findAllByMail(String mail) {
        return cartDAO.findAllByMail(mail);
    }

    @Override
    public void deleteFromCart(Integer id) {
        cartDAO.deleteById(id);
    }

    @Override
    public void deleteFromCartByMail(String name) {
        cartDAO.deleteByMail(name);
    }

    @Override
    public List<Cart> findAll() {
        return cartDAO.findAll();
    }
}
