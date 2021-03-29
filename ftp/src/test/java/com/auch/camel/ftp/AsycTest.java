//package com.auch.camel.ftp;
//
//import org.apache.camel.builder.AdviceWith;
//import org.apache.camel.builder.AdviceWithRouteBuilder;
//import org.junit.jupiter.api.Test;
//
///**
// * <p>异步测试</p>
// *
// * @author luohuiqi
// * @date 2021/3/22 11:33
// */
//public class AsycTest {
//
//    @Test
//    public void testAdvisedMockEndpoints() throws Exception {
//        // advice the first route using the inlined AdviceWith route builder
//        // which has extended capabilities than the regular route builder
//        AdviceWith.adviceWith(context.getRouteDefinitions().get(0), context, new AdviceWithRouteBuilder() {
//            @Override
//            public void configure() throws Exception {
//                // mock all endpoints
//                mockEndpoints();
//            }
//        });
//
//        getMockEndpoint("mock:direct:start").expectedBodiesReceived("Hello World");
//        getMockEndpoint("mock:direct:foo").expectedBodiesReceived("Hello World");
//        getMockEndpoint("mock:log:foo").expectedBodiesReceived("Bye World");
//        getMockEndpoint("mock:result").expectedBodiesReceived("Bye World");
//
//        template.sendBody("direct:start", "Hello World");
//
//        assertMockEndpointsSatisfied();
//
//        // additional test to ensure correct endpoints in registry
//        assertNotNull(context.hasEndpoint("direct:start"));
//        assertNotNull(context.hasEndpoint("direct:foo"));
//        assertNotNull(context.hasEndpoint("log:foo"));
//        assertNotNull(context.hasEndpoint("mock:result"));
//        // all the endpoints was mocked
//        assertNotNull(context.hasEndpoint("mock:direct:start"));
//        assertNotNull(context.hasEndpoint("mock:direct:foo"));
//        assertNotNull(context.hasEndpoint("mock:log:foo"));
//    }
//}
