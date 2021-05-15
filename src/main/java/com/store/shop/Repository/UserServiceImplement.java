package com.store.shop.Repository;

import com.store.shop.DAO.UserDAO;
import com.store.shop.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public User findUserByUsrename(String name) {
        return userDAO.findUserByUsrename(name);
    }
}
