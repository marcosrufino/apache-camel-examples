package com.apache.camel.demo.apachecamel.file;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RouteFile  extends RouteBuilder {

    @Override
    public void configure() throws Exception {



        //exemplo 6
     /*   from("timer:hello?period=10s")
                .pollEnrich("file:data/in/txt?delete=true&readLock=none")
                .choice()
                    .when(body().isNotNull())
                        .to("file:data/out/txt");*/

        //exemplo 7
    /*    from("timer:hello?period=10s")
                .pollEnrich("file:data/in/txt")
                .choice()
                    .when(body().isNotNull())
                        .split(body().tokenize("\n"))
                        .log("${body}")
                        .delay(1)
                        .to("file:data/out/txt?fileName=dados-$simple{date:now:yyyy-MM-dd}-${header.CamelSplitIndex}.txt");*/
        //exemplo 8
       /* from("timer:xml?period=10s")
                .pollEnrich("file:data/in/xml")
                .choice()
                .when(body().isNotNull())
                .transform().xpath("/catalog/book/price").log("${body}")
        ;*/
    }
}
