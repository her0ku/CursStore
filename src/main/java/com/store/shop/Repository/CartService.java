package com.store.shop.Repository;

import com.store.shop.Entity.Cart;

import java.util.List;

public interface CartService {
    void saveCart(Cart cart);
    List<Cart> findAllByMail(String mail);
    void deleteFromCart(Integer id);
    void deleteFromCartByMail(String name);
}
