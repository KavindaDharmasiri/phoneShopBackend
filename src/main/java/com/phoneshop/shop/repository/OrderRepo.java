package com.phoneshop.shop.repository;

import com.phoneshop.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, String> {

    List<Order> findAllByUserId(String id);

    Order findFirstByOrderByIdDesc();
}
