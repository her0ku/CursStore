package com.store.shop.Repository;

import com.store.shop.App.AppUser;
import com.store.shop.DAO.UserDAO;
import com.store.shop.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService, AppUserImplement {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for "+ email + ".");
        }
        return new AppUser(user);
    }

    public void signUpUser(User user){
        user.setRole("USER");
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDAO.save(user);
    }


    @Override
    public User findUserName(String email) {
        return userDAO.findByEmail(email);
    }
}
