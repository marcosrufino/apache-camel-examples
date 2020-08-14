package com.apache.camel.demo.apachecamel.converter;

import com.apache.camel.demo.apachecamel.converter.bean.OrderBean;
import com.apache.camel.demo.apachecamel.converter.model.Order;
import com.apache.camel.demo.apachecamel.converter.model.OrderFull;
import com.apache.camel.demo.apachecamel.converter.typeconverter.EmployerTypeConverter;
import com.apache.camel.demo.apachecamel.converter.typeconverter.OrderTypeConverter;
import com.apache.camel.demo.apachecamel.rest.bean.UserBean;
import com.apache.camel.demo.apachecamel.rest.model.Employer;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ThreadPoolBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Component
public class ConverterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        CamelContext context = getContext();
        context.getTypeConverterRegistry().addTypeConverters(new OrderTypeConverter());
        context.getTypeConverterRegistry().addTypeConverters(new EmployerTypeConverter());

        JacksonDataFormat orderFormat = new ListJacksonDataFormat(OrderFull.class);
        //Thread exemplo 01
        //ExecutorService threadPool = new ThreadPoolBuilder(context).poolSize(50).maxPoolSize(60).maxQueueSize(500).build("CustomThreadPool");
        //Thread exemplo 02
        //ExecutorService threadPool = Executors.newFixedThreadPool(20);


        from("timer:rest?period=10s")
                .to("direct:process-service");


        from("direct:process-service")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .toD("https://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/order")
                .unmarshal(orderFormat)
                .split().body()
                .multicast()
                //Thread exemplo 03
                .parallelProcessing()
                //##Thread exemplo 01 e 02
                //.threads().executorService(threadPool)
                .to("direct:order", "direct:employer")
                .log("${body}")
        ;

        from("direct:order")
                .convertBodyTo(Order.class)
                .bean(OrderBean.class)
                .log("Reposta : Thread: ${threadName}");

        from("direct:employer")
                .convertBodyTo(Employer.class)
        .bean(UserBean.class, "saveUser")
                .log("Reposta : Thread: ${threadName}");;
    }
}
