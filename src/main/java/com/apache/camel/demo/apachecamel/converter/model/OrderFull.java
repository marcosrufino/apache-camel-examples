package com.apache.camel.demo.apachecamel.converter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "createdAt",
        "name",
        "avatar",
        "department",
        "city",
        "zip",
        "state",
        "product",
        "price",
        "Account",
        "email",
        "ip",
        "address",
        "product_name",
        "transaction",
        "transaction"
})
public class OrderFull {

    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("department")
    private String department;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("state")
    private String state;
    @JsonProperty("product")
    private String product;
    @JsonProperty("price")
    private String price;
    @JsonProperty("Account")
    private String account;
    @JsonProperty("email")
    private String email;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("address")
    private String address;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("transaction")
    private String transaction;
    @JsonProperty("career")
    private String career;

}
