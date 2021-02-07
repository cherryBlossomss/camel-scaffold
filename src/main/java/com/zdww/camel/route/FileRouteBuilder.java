package com.zdww.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

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
                .to("{{api.destination}}");
    }
}
