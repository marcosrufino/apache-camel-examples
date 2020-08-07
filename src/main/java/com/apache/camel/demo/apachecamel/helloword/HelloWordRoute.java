package com.apache.camel.demo.apachecamel.helloword;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class HelloWordRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
       //exemplo 1
  /*      from("timer:hello?period=10s")
        .log("Hello Word");*/

        //exemplo 2
        from("timer:hello?period=10s")
                .setBody(simple("${date:now:yyyy/MM/dd}"))
                .log("hello word - ${body}");

        //exemplo 3
  /*      from("timer:hello?period=10s")
                .process(exchange -> {
                    exchange.getIn().setBody(LocalDateTime.now());
                })
                .log("hello word - ${body}");*/

        //exemplo 4
/*        from("timer:hello?period=10s")
                .process(exchange -> {
                    exchange.getIn().setBody(LocalDateTime.now());
                })
                .log("hello word - ${body}")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    body.concat(" - mudei o body ");
                    exchange.setProperty("teste", "usando variavel");
                    exchange.getIn().setBody(body);
                })
                .log("${body} - ${exchangeProperty.teste}");*/


        //exemplo 5
/*        from("timer:hello?period=10s")
                .to("direct:router2")
                .to("direct:router3")
                .to("direct:router4");

        from("direct:router2")
                .log("chamando a rota 2")
                .setBody(constant("retorno rota 2"));

        from("direct:router3")
                .log("chamando a rota 3")
                .log("${body}");

        from("direct:router4")
                .log("chamando a rota 4")
                .log("${body}")
                .setBody(simple("${body} - rota 4"))
                .log("${body}");*/
    }

}
