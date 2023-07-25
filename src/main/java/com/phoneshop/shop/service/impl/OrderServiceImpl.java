package com.phoneshop.shop.service.impl;

import com.phoneshop.shop.dto.OrderDTO;
import com.phoneshop.shop.entity.Order;
import com.phoneshop.shop.repository.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements com.phoneshop.shop.service.orderService {

    @Autowired
    private OrderRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveorder(Order dto) {
        System.out.println(dto.getId());
        repo.save(mapper.map(dto, Order.class));
    }

    @Override
    public void deleteorder(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Phone id number.. No Such Phone..!");
        }
    }

    @Override
    public void updateorder(Order dto) {
        repo.save(mapper.map(dto, Order.class));
    }

    @Override
    public OrderDTO searchorder(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), OrderDTO.class);
        } else {
            throw new RuntimeException("No Car For " + id + " ..!");
        }
    }

    @Override
    public List<OrderDTO> getAllorders() {
        return mapper.map(repo.findAll(), new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    @Override
    public List<Order> getAllordersBypId(String id) {
        return mapper.map(repo.findAllByUserId(id), new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    @Override
    public List<Order> getAllordersBypIdComplet(String id) {
        return mapper.map(repo.findAllByUserId(id), new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    @Override
    public Order getLastRecord() {
        return repo.findFirstByOrderByIdDesc();
    }
}
