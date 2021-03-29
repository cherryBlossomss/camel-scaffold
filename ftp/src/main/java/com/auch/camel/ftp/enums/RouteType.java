package com.auch.camel.ftp.enums;

import com.auch.camel.ftp.builder.BaseRouteBuilder;
import com.auch.camel.ftp.builder.HttpRouteBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum RouteType {

    /**
     * http
     */
    HTTP("http",new HttpRouteBuilder()),
    /**
     * jdbc
     */
    JDBC("jdbc",new HttpRouteBuilder()),

    /**
     * jetty
     */
    JETTY("jetty",new HttpRouteBuilder()),

    /**
     * timer
     */
    TIMER("timer",new HttpRouteBuilder()),

    /**
     * cxf
     */
    CXF("cxf",new HttpRouteBuilder());

    private final String code;

    private final BaseRouteBuilder routeBuilder;

    public static RouteType getRouteType(String code) {
        return Arrays.stream(RouteType.values()).filter(x -> Objects.equals(x.getCode(), code))
                .findFirst().orElseThrow(() -> new RuntimeException("code有误"));
    }
}

