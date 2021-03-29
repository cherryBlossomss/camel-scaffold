package com.auch.camel.ftp.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>链接实体</p>
 *
 * @author luohuiqi
 * @date 2021/3/26 0:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "链接对象")
public class LinkVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "源id")
    private String sourceId;

    @ApiModelProperty(value = "目标id")
    private String targetId;
}
