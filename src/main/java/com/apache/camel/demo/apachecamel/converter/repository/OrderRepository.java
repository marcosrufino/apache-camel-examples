package com.apache.camel.demo.apachecamel.converter.repository;

import com.apache.camel.demo.apachecamel.converter.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
