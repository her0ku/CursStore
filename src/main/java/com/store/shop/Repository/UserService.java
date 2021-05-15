package com.store.shop.Repository;

import com.store.shop.Entity.User;

public interface UserService {
    void addUser(User user);
    User findUserByUsrename(String name);
}
