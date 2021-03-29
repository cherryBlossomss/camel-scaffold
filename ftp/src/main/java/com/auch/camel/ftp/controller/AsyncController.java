package com.auch.camel.ftp.controller;

import com.auch.camel.ftp.bean.SimpleBean;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.SpringBootCamelContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2021/3/19 11:49
 */
@RestController
@RequestMapping("/http")
public class AsyncController {

    @Resource
    private SpringBootCamelContext camelContext;


    @GetMapping("/jetty")
    public String saveHttpService() throws Exception {
        //监听端口
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("jetty:http://0.0.0.0:8097/invoke")
                        .id("8097")
                        .setBody(constant("World"))
                        .bean(SimpleBean.class, "hello")
                        .to("log:consumer001?showExchangeId=true")
                        .wireTap("direct:001")
                        .to("direct:002");
                from("direct:001")
                        .id("001")
                        .process(exchange -> {
                            System.out.println("in id=001");
                            exchange.getMessage().setBody(constant("data in 001"));
                        })
                        .to("log:consumer002?showExchangeId=true");


                from("direct:002")
                        .id("002")
                        .process(exchange -> {
                            System.out.println("in id=002");
                            TimeUnit.SECONDS.sleep(5);
                            exchange.getMessage().setBody(constant("data in 002"));
                        });
            }
        });
        return "创建成功";
    }
}
