package com.auch.camel.webservice;

import com.auch.camel.webservice.server.CamelCXFServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

/**
 * <p>webService Component</p>
 * server
 *
 * @author luohuiqi
 * @date : 2021/3/15 15:07
 **/
@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
        String address = "http://127.0.0.1:9022/camel-cxf/greeter-service";
        Endpoint.publish(address, new CamelCXFServiceImpl());
        System.out.println("WebService 发布成功 , address : " + address);
    }

}
