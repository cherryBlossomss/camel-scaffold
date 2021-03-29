package com.auch.camel.webservice.server;

import com.auch.camel.webservice.route.WebserviceRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelReleaseServiceMain {


    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new WebserviceRoute());
            context.start();
            // 通用没有具体业务意义的代码，只是为了保证主线程不退出
            synchronized (CamelReleaseServiceMain.class) {
                CamelReleaseServiceMain.class.wait();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

}
