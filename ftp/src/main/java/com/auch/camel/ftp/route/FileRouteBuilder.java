package com.auch.camel.ftp.route;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;


/**
 * @author luohuiqi
 * @Description:
 * @Date: 2021/1/21 16:38
 */
@Component
public class FileRouteBuilder extends RouteBuilder {

    private static final String BASE_FOLDER = "/Users/luohuiqi/work/workspace/me/camel-scaffold/src/test/java/com/zdww/camel";
    private static final String SOURCE_FOLDER = BASE_FOLDER + "/source";
    private static final String DESTINATION_FOLDER = BASE_FOLDER + "/destination";

    @Override
    public void configure() throws Exception {
        from("{{api.source}}")
                .process(exchange -> {
                    // 从source获取消息
                    Message input = exchange.getIn();
                    // 从消息里面获取消息体
                    String data = input.getBody(String.class);
                    // 解析消息体以及封装为需要的结构
                    StringTokenizer split = new StringTokenizer(data, ",");
                    String eid = split.nextToken();
                    String ename = split.nextToken();
                    String esal = split.nextToken();
                    String datamodified = "{eid:" + eid + ",ename:" + ename + ",esal:" + esal + "}";
                    // 获取输出消息以及设置消息体
                    Message output = exchange.getMessage();
                    output.setBody(datamodified);
                })
                .to("{{api.destination}}");
    }
}
