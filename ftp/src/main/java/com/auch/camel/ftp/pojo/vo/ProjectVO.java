package com.auch.camel.ftp.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>项目交互数据</p>
 *
 * @author luohuiqi
 * @date 2021/3/23 16:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Project对象")
public class ProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "最初的id")
    private String initialId;

    // TODO 测试用
    @ApiModelProperty(value = "jetty")
    private String jetty;

    @ApiModelProperty(value = "控件")
    private List<RouteVO> routes;

    @ApiModelProperty(value = "链接")
    private List<LinkVO> links;
}
