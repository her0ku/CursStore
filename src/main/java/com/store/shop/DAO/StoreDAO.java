package com.store.shop.DAO;

import com.store.shop.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDAO extends JpaRepository<Store, Integer> {
}
