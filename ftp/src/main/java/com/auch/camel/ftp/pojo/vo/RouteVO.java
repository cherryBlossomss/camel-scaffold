package com.auch.camel.ftp.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>组件实体</p>
 *
 * @author luohuiqi
 * @date 2021/3/26 10:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "组件对象")
public class RouteVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "模式")
    private String mode;

    @ApiModelProperty(value = "配置")
    private Map<String, Object> properties;

    @ApiModelProperty(value = "在蓝图的坐标：x")
    private Integer x;

    @ApiModelProperty(value = "在蓝图的坐标：y")
    private Integer y;

}
