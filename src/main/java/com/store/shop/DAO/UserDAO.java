package com.store.shop.DAO;

import com.store.shop.App.AppUser;
import com.store.shop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findUserByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
