package com.zdww.camel;

import com.zdww.camel.route.FileRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author luohuiqi
 * @Description:
 * @Date: 2021/1/21 15:29
 */
public class Demo001 {

    private static final long DURATION_MILIS = 10000;

     // /Users/luohuiqi/work/workspace/me/camel002/src/test/java/demo.txt  ==>  /Users/luohuiqi/Desktop/WW/

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        // 添加文件路由
        camelContext.addRoutes(new FileRouteBuilder());

        camelContext.start();
        // 为了方便移动文件，故sleep一定时间
        Thread.sleep(DURATION_MILIS);
        camelContext.stop();


    }

}
