package com.serverless.rest;

import com.serverless.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice
@RequiredArgsConstructor
public class CorsResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final AppProperties appProperties;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        response.getHeaders().set("Access-Control-Allow-Origin", appProperties.getCors().getAllowOrigin());
        response.getHeaders().set("Access-Control-Allow-Credentials", appProperties.getCors().getAllowCredentials());
        return body;
    }

}
