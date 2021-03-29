package com.auch.camel.ftp.route;

import com.auch.camel.ftp.enums.RouteType;
import com.auch.camel.ftp.pojo.vo.LinkVO;
import com.auch.camel.ftp.pojo.vo.ProjectVO;
import com.auch.camel.ftp.pojo.vo.RouteVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2021/3/25 16:58
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class ComponentBuilder extends RouteBuilder {

    private ProjectVO project;

    @Override
    public void configure() throws Exception {
        RouteDefinition rd = from(project.getJetty())
                .description(project.getInitialId(), "接收数据，并根据机构id查询本机构医生数据", null);
        addTo(rd, project);
        // 添加project-component
        List<RouteDefinition> routeDefinitions = this.addComponent(project.getRoutes());
        System.err.println(routeDefinitions);
    }

    /**
     * 路由转换
     *
     * @param routes 路由参数
     * @return {@link List<RouteDefinition>} 路由定义
     */
    public List<RouteDefinition> addComponent(List<RouteVO> routes) {
        return routes.stream()
                .map(route -> RouteType.getRouteType(route.getType()).getRouteBuilder().setRoute(route).configure())
                .collect(Collectors.toList());
    }

    /**
     * 添加自路由，即to("direct:"+xxx)
     *
     * @param routeDefinition 路由定义
     * @param project         项目数据
     */
    public void addTo(RouteDefinition routeDefinition, ProjectVO project) {
        Map<String, String> links = project.getLinks().stream()
                .collect(Collectors.toMap(LinkVO::getSourceId, LinkVO::getTargetId));
        List<String> tos = convertorLinks(links, project.getInitialId(), new ArrayList<>());
        List<String> toss = tos.stream().map(x -> "direct:" + x).collect(Collectors.toList());
        toss.forEach(routeDefinition::to);
    }

    /**
     * 连段到面：对每一个link排序
     *
     * @param links    链接
     * @param sourceId 源id
     * @param tos      排序的集合
     * @return {@link List<String>} 排序集合
     */
    public List<String> convertorLinks(Map<String, String> links, String sourceId, List<String> tos) {
        String targetId = links.get(sourceId);
        if (!Objects.isNull(targetId)) {
            tos.add(targetId);
            return convertorLinks(links, targetId, tos);
        }
        return tos;
    }
}
