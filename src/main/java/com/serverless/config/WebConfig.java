package com.serverless.config;

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.services.lambda.runtime.Context;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

import static com.amazonaws.serverless.proxy.RequestReader.LAMBDA_CONTEXT_PROPERTY;

@Configuration
@Slf4j
public class WebConfig {

    @RequestScope
    @Bean
    public Context context(HttpServletRequest httpServletRequest) {
        Context context = (Context) httpServletRequest.getAttribute(LAMBDA_CONTEXT_PROPERTY);

        if (context == null) {
            log.warn("Lambda context not found. Defaulting to mock Lambda context");
            return new MockLambdaContext();
        }

        return context;
    }

}
