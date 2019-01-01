package com.huawei.hystrix.csehystrix;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = HystrixDashboardProperties.PREFIX)
public class HystrixDashboardProperties {

    public static final String PREFIX = "hystrix.dashboard";

    private TurbineProperties turbine = new TurbineProperties();

    public TurbineProperties getTurbine() {
        return turbine;
    }

    public void setTurbine(TurbineProperties turbine) {
        this.turbine = turbine;
    }

    public static class TurbineProperties {

        public static final String TURBINE_STREAM = "http://127.0.0.1:8989/turbine.stream";

        private String uri = TURBINE_STREAM;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
}