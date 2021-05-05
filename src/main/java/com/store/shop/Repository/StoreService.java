package com.store.shop.Repository;

import com.store.shop.Entity.Store;

import java.util.List;

public interface StoreService {
    void addStore(Store store);
    List<Store> showAllStores();
}
