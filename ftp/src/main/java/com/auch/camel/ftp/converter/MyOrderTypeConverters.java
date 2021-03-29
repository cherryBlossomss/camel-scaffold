package com.auch.camel.ftp.converter;

import com.auch.camel.ftp.pojo.entity.RoleDO;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.springframework.stereotype.Component;

/**
 * <p>订单转换器</p>
 *
 * @author luohuiqi
 * @date 2021/3/22 18:41
 */
@Component
@Converter(generateLoader = true)
public class MyOrderTypeConverters implements TypeConverters {

    @Converter
    public RoleDO toMyOrder(Integer orderId) {
        return new RoleDO().setId(orderId).setName("you are SB");
    }
}
