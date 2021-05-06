package com.store.shop.Repository;

import com.store.shop.DAO.BrandDAO;
import com.store.shop.Entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandServiceImplement implements BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @Override
    @Transactional
    public void addBrand(Brand brand) {
        brandDAO.save(brand);
    }

    @Override
    @Transactional
    public List<Brand> findAllBrands() {
        return brandDAO.findAll();
    }
}
