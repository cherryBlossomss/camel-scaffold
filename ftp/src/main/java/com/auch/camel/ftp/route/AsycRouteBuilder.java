package com.auch.camel.ftp.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * <p>测试route</p>
 *
 * @author luohuiqi
 * @date 2021/3/18 20:02
 */

public class AsycRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:fire?period=5000")
                .setBody(constant("Hello Chapter3"))
                .process(exchange -> {
                    String inBody = exchange.getIn().getBody(String.class);
                    log.info("Received in message with body {}", inBody);
                    log.info("Prefixing body ...");
                    inBody = "Prefixed " + inBody;
                    exchange.getIn().setBody(inBody);
                })
                .to("log:MyRoute")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    if (body.startsWith("Prefixed")) {
                        body = body.substring("Prefixed".length());
                        exchange.getIn().setBody(body);
                    }
                })
                .to("log:MyRoute");


    }
}
