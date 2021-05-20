package com.store.shop.Repository;

import com.store.shop.Entity.User;

public interface AppUserImplement {
    User findUserName(String email);
}
