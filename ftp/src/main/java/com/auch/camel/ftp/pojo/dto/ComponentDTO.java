package com.auch.camel.ftp.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>组件传输对象</p>
 *
 * @author luohuiqi
 * @date 2021/3/25 11:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ComponentDTO implements Serializable {

    private static final long serialVersionUID = -2054359538140713354L;

    private String id;

    private String url;

    private String name;

    private String description;

    private Map<String, Object> config;
}
