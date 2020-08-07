package com.apache.camel.demo.apachecamel.rest.bean;

import com.apache.camel.demo.apachecamel.rest.model.Employer;
import com.apache.camel.demo.apachecamel.rest.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBean {

    @Autowired
    EmployerService employerService;

    public List<Employer> listUser(){
       return employerService.list();
    }

    public void saveList(List<Employer> employerList){
        employerService.save(employerList);
    }

    public void saveUser(Employer employer){
        employerService.save(employer);
    }

}
