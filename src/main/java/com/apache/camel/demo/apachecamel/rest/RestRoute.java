package com.apache.camel.demo.apachecamel.rest;

import com.apache.camel.demo.apachecamel.rest.bean.UserBean;
import com.apache.camel.demo.apachecamel.rest.model.Employer;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;

//@Component
public class RestRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        JacksonDataFormat userFormat = new ListJacksonDataFormat(Employer.class);

        from("timer:rest?period=10s")
                .to("direct:process-service");


        from("direct:process-service")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .toD("https://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer")
                .unmarshal(userFormat)
                .bean(UserBean.class, "saveList")
                .log("${body}")
        ;
    }
}
