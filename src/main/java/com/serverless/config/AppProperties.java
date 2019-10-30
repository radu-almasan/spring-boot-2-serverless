package com.serverless.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("app")
@Data
public class AppProperties {

    private Cors cors;

    @Data
    public static class Cors {

        private String allowOrigin;
        private String allowCredentials;

    }

}
