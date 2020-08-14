package com.apache.camel.demo.apachecamel.jpa1;

import com.apache.camel.demo.apachecamel.rest.bean.UserBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:jpa1?period=10s")
                .bean(UserBean.class,"listUser")
                .marshal().json().log("${body}");


    }
}
