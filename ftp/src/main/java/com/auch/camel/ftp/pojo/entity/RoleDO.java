package com.auch.camel.ftp.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author luohuiqi
 * @since 2020-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleDO implements Serializable {

    private static final long serialVersionUID = -2054359538140713354L;

    private Integer id;

    private String code;

    private String name;

    private String tips;


}
