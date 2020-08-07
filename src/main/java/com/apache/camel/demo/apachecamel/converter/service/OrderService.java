package com.apache.camel.demo.apachecamel.converter.service;

import com.apache.camel.demo.apachecamel.converter.model.Order;
import com.apache.camel.demo.apachecamel.converter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }
}
