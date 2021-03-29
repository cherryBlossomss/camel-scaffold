package com.auch.camel.ftp.builder;

import com.auch.camel.ftp.pojo.vo.RouteVO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.camel.model.RouteDefinition;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2021/3/26 17:39
 */
@Data
@Accessors(chain = true)
public abstract class BaseRouteBuilder {

    /**
     * 组件信息
     */
    private RouteVO route;

    /**
     * 判断是否是第一个组件，若是，则endpoint的url为根据component的类型而定，若不是，则为direct+id
     */
    protected boolean isInitial() {
        return false;
    }

    /**
     * 路由组装，包括初始化路由以及对路由相关定义
     *
     * @return {@link RouteDefinition} 路由定义
     */
    public final RouteDefinition configure() {
        RouteDefinition routeDefinition = isInitial() ? RouteDefinition.fromUri(initial(route)) :
                RouteDefinition.fromUri("direct:" + route.getId());
        return handle(routeDefinition, route);
    }

    /**
     * 路由处理：主要实现包装process以及to方法
     *
     * @param routeDefinition 路由定义
     * @param route           路由参数
     * @return {@link RouteDefinition} 路由定义
     */
    protected abstract RouteDefinition handle(RouteDefinition routeDefinition, RouteVO route);

    /**
     * 初始化组件，设置组件url
     *
     * @param route 组件
     * @return {@link String 组件url},比如：http:hostname[:port][/resourceUri][?options]
     */
    protected abstract String initial(RouteVO route);
}
