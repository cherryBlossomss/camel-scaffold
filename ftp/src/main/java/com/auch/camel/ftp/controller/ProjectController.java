package com.auch.camel.ftp.controller;

import com.auch.camel.ftp.pojo.vo.ProjectVO;
import com.auch.camel.ftp.route.ComponentBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.camel.spring.boot.SpringBootCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Http</p>
 *
 * @author luohuiqi
 * @date 2021/3/23 15:49
 */
@Api(tags = "project服务")
@Controller
@RequestMapping("/project")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectController {

    private final SpringBootCamelContext camelContext;

    @ApiOperation(value = "新增")
    @PostMapping
    public String add(@RequestBody ProjectVO project) throws Exception {
        camelContext.addRoutes(new ComponentBuilder().setProject(project));
        return "创建成功";
    }


}
