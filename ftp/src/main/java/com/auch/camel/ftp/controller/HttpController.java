package com.auch.camel.ftp.controller;

import cn.hutool.db.ds.simple.SimpleDataSource;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.auch.camel.ftp.bean.SimpleBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.spring.boot.SpringBootCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * <p>Http相关项目</p>
 *
 * @author luohuiqi
 * @date 2021/3/23 15:49
 */
@Api(tags = "xxx服务")
@Controller
@RequestMapping("/https")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HttpController {

    private final SpringBootCamelContext camelContext;

    @ApiOperation(value = "新增")
    @GetMapping("/add")
    public String add(@RequestParam String jetty) throws Exception {
        String url = "jdbc:mysql://cdb-0fhns094.cd.tencentcdb.com:10096/hlwyy?serverTimezone=UTC";
        SimpleDataSource basicDataSource = new SimpleDataSource(url, "root", "ch116699", "com.mysql.cj.jdbc.Driver");

        // 1.数据转化: Component转化为Route,并添加进上下文
        // 2.数据转化: Target ->map(sourceId,TargetId)
        // 3.路由编排:  根据已经转化好的List<component> 以及map(sourceId,TargetId)进行服务编排
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                // 接收http请求
                from("jetty:" + jetty)
                        .description("xxx", "接收数据，并根据机构id查询本机构医生数据", null)
                        .process(x -> System.err.println("001-pattern:" + x.getPattern()))
                        .to("direct:002")
                        .to("direct:003")
                        .to("direct:004");

                from("direct:002")
                        .description("002", "获取orgainization以获取对应机构的doctor", null)
                        .setBody(constant("XXXXXXXXXX"))
                        .process(exchange ->
                                System.err.println("I'm just passing data -002")
                        );

                // 获取organization
//                from("direct:002")
//                        .description("002", "获取orgainization以获取对应机构的doctor", null)
//                        .setBody(constant("XXXXXXXXXX"))
//                        .process(exchange ->
//                                System.err.println("I'm just passing data -002")
//                        );


                // 数据库查询
                bindToRegistry("DataSource", basicDataSource);
                from("direct:003")

                        .description("003-001", "根据organization查询响应医生", null)
                        .process(exchange -> {
                            System.err.println("003-001-pattern:" + exchange.getPattern());
                            String body = exchange.getIn().getBody(String.class);
                            log.info("Received in message with body {}", body);
                            long organizationId = Long.parseLong(JSONUtil.parseObj(body).getStr("organizationId"));
                            String statements = "SELECT id,org_sec_name\n" +
                                    "FROM medical_organization \n" +
                                    "WHERE id =" + organizationId;
                            System.out.println(statements);
                            exchange.getMessage().setBody(statements);
                        })
                        .to("jdbc:DataSource?outputType=SelectList&useHeadersAsParameters=true")

                        .process(exchange -> {
                            exchange.setPattern(ExchangePattern.InOut);
                            System.err.println("003-002-pattern:" + exchange.getPattern());
                            JSONArray body = exchange.getIn().getBody(JSONArray.class);
                            long id = Long.parseLong(JSONUtil.parseObj(body.get(0)).getStr("id"));
                            String statements = "SELECT id,`name`\n" +
                                    "FROM doctor \n" +
                                    "WHERE  organization_id =" + id;
                            System.out.println(statements);
                            exchange.getMessage().setBody(statements);
                        })
                        .to("jdbc:DataSource?outputType=SelectList&useHeadersAsParameters=true");

                from("direct:004")
                        .description("004", "数据返回路由", null)
                        .process(x -> {
                            System.err.println("I'm just passing data -004");
                            JSONArray body = x.getIn().getBody(JSONArray.class);
                            System.err.println(body);
//                            x.getMessage().setBody(body);
                        });
            }
        });
        System.err.println(camelContext.getTracingPattern());
        return "创建成功";
    }


    @ApiOperation(value = "测试-wireTap")
    public String test() throws Exception {
        //监听端口
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                // 接收http请求
                from("jetty:http://0.0.0.0:8866/user")
                        .description("8888", "接收http请求", null)
                        .setBody(constant("World"))
                        .bean(SimpleBean.class, "hello")
                        .to("log:consumer001?showExchangeId=true")
                        .wireTap("direct:001")
                        .to("direct:002");
                // wire-tap分叉001
                from("direct:001")
                        .id("001")
                        .process(exchange -> {
                            System.out.println("in id=001");
                            exchange.getMessage().setBody(constant("data in 001"));
                        })
                        .to("log:consumer002?showExchangeId=true");
                // 继续执行002

                RouteDefinition.fromUri("direct:002")
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
