package com.apache.camel.demo.apachecamel.rest.repository;

import com.apache.camel.demo.apachecamel.rest.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employer, Long> {

}
