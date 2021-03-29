package com.auch.camel.ftp.service.impl;

import com.auch.camel.ftp.pojo.vo.LinkVO;
import com.auch.camel.ftp.pojo.vo.ProjectVO;
import com.auch.camel.ftp.pojo.vo.RouteVO;
import com.auch.camel.ftp.service.ProjectService;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
public class ProjectServiceImpl extends RouteBuilder implements ProjectService {

    private String jerry;
    private ProjectVO project;

    @Override
    public void configure() throws Exception {
        RouteDefinition rd = from(jerry);
//        addTo(rd, project);
    }


    //     1.数据转化: Component(RouteVO) ==》Route,并添加进上下文
    //     2.数据转化: links ==》 ap(sourceId,TargetId)
    //     3.路由编排:  根据已经转化好的List<Route> 以及map(sourceId,TargetId)进行服务编排
    @Override
    public void choreography(ProjectVO project) {

    }


    public static List<Route> convertorLinks(List<RouteVO> routes) {
        return new ArrayList<>();
    }


}
