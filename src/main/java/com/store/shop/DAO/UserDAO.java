package com.store.shop.DAO;

import com.store.shop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findUserByUsrename(String name);
}
