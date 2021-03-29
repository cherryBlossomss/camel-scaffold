package com.auch.camel.webservice.route;

import com.auch.camel.webservice.server.CamelCXFServiceInter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfComponent;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.springframework.stereotype.Component;

/**
 * <p>WS路由</p>
 *
 * @author luohuiqi
 * @date 2021/3/17 19:39
 */
@Component
public class WebserviceRoute extends RouteBuilder {

    private static final String SERVICE_ADDRESS = "http://localhost:9022/camel-cxf/greeter-service?wsdl";

    private static final String SERVICE_CLASS = "serviceClass=com.camel.webservice.server.CamelCXFServiceInter";

    private static final String WSDL_LOCATION = "wsdlURL=wsdl/queryService.wsdl";

    private static final String ROUTER_ADDRESS = "http://localhost:8088/CamelCXFService/queryService";

    private static final String ROUTER_ENDPOINT_URI = "cxf://" + ROUTER_ADDRESS + "?" + SERVICE_CLASS + "&"
            + WSDL_LOCATION + "&dataFormat=POJO";

    @Override
    public void configure() throws Exception {
        System.err.println("ROUTER_ENDPOINT_URI : " + ROUTER_ENDPOINT_URI);

        // a component acts as a factory for endpoints
        CxfComponent cxfComponent = new CxfComponent(getContext());
        CxfEndpoint serviceEndpoint = new CxfEndpoint(SERVICE_ADDRESS, cxfComponent);
        System.out.println(serviceEndpoint.isSynchronous());
        serviceEndpoint.setServiceClass(CamelCXFServiceInter.class);

        from(ROUTER_ENDPOINT_URI)
                .to("log:CamelCxfExample?showExchangeId=true")
                .to(serviceEndpoint);
        System.err.println("address : " + ROUTER_ADDRESS + "?wsdl");
    }
}
