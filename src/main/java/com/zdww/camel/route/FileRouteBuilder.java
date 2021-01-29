package com.zdww.camel.route;

import com.zdww.camel.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * @author luohuiqi
 * @Description:
 * @Date: 2021/1/21 16:38
 */
public class FileRouteBuilder extends RouteBuilder {

    private static final String SOURCE_FOLDER = "/Users/luohuiqi/work/workspace/me/camel002/src/test/java";
    private static final String DESTINATION_FOLDER = "/Users/luohuiqi/Desktop/WW";

    @Override
    public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER+ "?delete=true")
                .dynamicRouter().method(this,"dodirect")
                .process(new FileProcessor())
                .to("file://" + DESTINATION_FOLDER);
    }
}
