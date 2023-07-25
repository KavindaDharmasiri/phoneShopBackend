package com.phoneshop.shop.service;

import com.phoneshop.shop.dto.OrderDTO;
import com.phoneshop.shop.entity.Order;

import java.util.List;

public interface orderService {
    void saveorder(Order dto);

    void deleteorder(String id);

    void updateorder(Order dto);

    OrderDTO searchorder(String id);

    List<OrderDTO> getAllorders();

    List<Order> getAllordersBypId(String id);

    List<Order> getAllordersBypIdComplet(String id);

    Order getLastRecord();
}
