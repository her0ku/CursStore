package com.store.shop.Repository;

import com.store.shop.Entity.User;

import java.util.List;

public interface AppUserImplement {
    User findUserName(String email);
    List<User> findAllUsers();
}
