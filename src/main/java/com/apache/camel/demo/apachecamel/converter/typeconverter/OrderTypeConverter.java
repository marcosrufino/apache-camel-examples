package com.apache.camel.demo.apachecamel.converter.typeconverter;

import com.apache.camel.demo.apachecamel.converter.model.Order;
import com.apache.camel.demo.apachecamel.converter.model.OrderFull;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

@Converter
public class OrderTypeConverter implements TypeConverters {

    @Converter
    public Order convertFullOrderToOrder(OrderFull orderFull){

        Order order = new Order();
        order.setIp(orderFull.getIp());
        order.setCreatedAt(orderFull.getCreatedAt());
        order.setEmail(orderFull.getEmail());
        order.setAccount(orderFull.getAccount());
        order.setPrice(orderFull.getPrice());
        order.setProduct(orderFull.getProduct());
        order.setProductName(orderFull.getProductName());
        order.setTransaction(orderFull.getTransaction());
        return order;
    }
}
