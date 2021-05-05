package com.store.shop.Repository;

import com.store.shop.DAO.StoreDAO;
import com.store.shop.Entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImplement implements StoreService{

    @Autowired
    private StoreDAO storeDAO;

    @Override
    public void addStore(Store store) {
        storeDAO.save(store);
    }

    @Override
    public List<Store> showAllStores() {
        return storeDAO.findAll();
    }
}
