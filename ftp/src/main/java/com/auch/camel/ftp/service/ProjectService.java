package com.auch.camel.ftp.service;

import com.auch.camel.ftp.pojo.vo.ProjectVO;
import org.apache.camel.Route;

public interface ProjectService {

    /**
     * 1.数据转化: Component(RouteVO) ==》Route,并添加进上下文
     * 2.数据转化: links ==》 ap(sourceId,TargetId)
     * 3.路由编排:  根据已经转化好的List<component> 以及map(sourceId,TargetId)进行服务编排
     *
     * @param project 项目数据
     * @return {@link Route}
     */
    void choreography(ProjectVO project);
}
