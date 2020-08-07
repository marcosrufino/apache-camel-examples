package com.apache.camel.demo.apachecamel.converter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PEDIDO")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createdAt;
    private String product;
    private String price;
    private String account;
    private String email;
    private String ip;
    private String productName;
    private String transaction;

}
