package com.apache.camel.demo.apachecamel.converter.typeconverter;

import com.apache.camel.demo.apachecamel.converter.model.OrderFull;
import com.apache.camel.demo.apachecamel.rest.model.Employer;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

@Converter
public class EmployerTypeConverter implements TypeConverters {

    @Converter
    public Employer convertFullOrderToOrder(OrderFull orderFull){

        Employer employer = new Employer();
        employer.setCareer(orderFull.getCareer());
        employer.setDepartment(orderFull.getDepartment());
        employer.setFirst_name(orderFull.getName().split(" ")[0]);
        employer.setLast_name(orderFull.getName().split(" ")[1]);
        return employer;
    }
}
