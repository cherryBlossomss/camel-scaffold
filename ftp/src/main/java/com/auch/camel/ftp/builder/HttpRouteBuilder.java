package com.auch.camel.ftp.builder;

import com.auch.camel.ftp.enums.RouteType;
import com.auch.camel.ftp.pojo.vo.RouteVO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.camel.ExchangePattern;
import org.apache.camel.model.RouteDefinition;

/**
 * <p>Http 路由</p>
 *
 * @author luohuiqi
 * @date 2021/3/26 17:40
 */
@Data
@Accessors(chain = true)
public class HttpRouteBuilder extends BaseRouteBuilder {

    private static final String url = "http://0.0.0.0:8097/invoke";

    @Override
    public RouteDefinition handle(RouteDefinition routeDefinition, RouteVO route) {
        return routeDefinition.description(route.getId(), route.getDescription(), null)
                .to("log:consumer001?showExchangeId=true");
    }

    @Override
    public String initial(RouteVO route) {
        return ExchangePattern.InOnly.name().equalsIgnoreCase(route.getMode()) ?
                RouteType.JETTY.getCode() + url : RouteType.HTTP.getCode() + url;
    }
}
