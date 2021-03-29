//package com.auch.camel.ftp.route;
//
//import com.auch.camel.ftp.pojo.dto.ComponentDTO;
//import org.apache.camel.builder.RouteBuilder;
//
///**
// * <p>Http构建器</p>
// *
// * @author luohuiqi
// * @date 2021/3/19 09:20
// */
//public class HttpBuilder extends RouteBuilder {
//
//
//
//    @Override
//    public void configure() throws Exception {
//        from("jetty:" + component.getUrl())
//                .description(component.getId(), component.getDescription(), null);
//    }
//
//    public void configure(ComponentDTO component) throws Exception {
//
//        this.configure();
//        from("jetty:" + component.getUrl())
//                .description(component.getId(), component.getDescription(), null);
//    }
//
//}
