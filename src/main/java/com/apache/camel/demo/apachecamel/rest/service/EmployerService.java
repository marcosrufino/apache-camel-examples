package com.apache.camel.demo.apachecamel.rest.service;

import com.apache.camel.demo.apachecamel.rest.model.Employer;
import com.apache.camel.demo.apachecamel.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    @Autowired
    UserRepository userRepository;

    public void save(Employer employer){
        userRepository.save(employer);
    }

    public List<Employer> list(){
       return userRepository.findAll();
    }

    public void save(List<Employer> employerList) {
        userRepository.saveAll(employerList);
    }
}
