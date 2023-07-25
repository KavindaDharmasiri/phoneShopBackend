package com.phoneshop.shop.controller;

import com.phoneshop.shop.dto.OrderDTO;
import com.phoneshop.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class OrderController {
    private static final ArrayList<String> allImages = new ArrayList<>();
    String tempOne;

    @Autowired
    com.phoneshop.shop.service.orderService service;

    @GetMapping(path = "/getAll", params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getAllOrder(@RequestParam String id) {
        System.out.println(id);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", service.getAllordersBypId(id));
    }

    @GetMapping(path = "/getLast", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getLastOrder() {
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", service.getLastRecord());
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getAllOrders() {
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", service.getAllorders());
    }


    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil savePhone(@RequestBody OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getId(), orderDTO.getUserId(), orderDTO.getPhoneId(), orderDTO.getName(), orderDTO.getBrand(),
                orderDTO.getPrice(), orderDTO.getImage1(), orderDTO.getQuantity(), orderDTO.getType());

        service.saveorder(order);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Save", null);
    }


    @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil updatePhone(@RequestBody Order order) {

        service.updateorder(order);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Updated", null);
    }


}


