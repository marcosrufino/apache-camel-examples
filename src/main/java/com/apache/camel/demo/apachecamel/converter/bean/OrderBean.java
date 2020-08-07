package com.apache.camel.demo.apachecamel.converter.bean;

import com.apache.camel.demo.apachecamel.converter.model.Order;
import com.apache.camel.demo.apachecamel.converter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBean {

    @Autowired
    OrderService orderService;

    public void saverOrder(Order order){
        orderService.save(order);
    }
}
