package com.apache.camel.demo.apachecamel.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "PESSOAS")
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String first_name;
    private String last_name;
    private String career;
    private String department;
}
