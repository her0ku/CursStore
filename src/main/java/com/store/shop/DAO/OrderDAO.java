package com.store.shop.DAO;

import com.store.shop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findAllByMail(String mail);
    Order findDistinctFirstByMail(String mail);
    void deleteByMail(String mail);
}
