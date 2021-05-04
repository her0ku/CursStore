package com.store.shop.DAO;

import com.store.shop.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandDAO extends JpaRepository<Brand, Integer> {
}
