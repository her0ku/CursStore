package com.store.shop.Repository;

import com.store.shop.Entity.Brand;

import java.util.List;

public interface BrandRepository {
    void addBrand(Brand brand);
    List<Brand> findAllBrands();
}
