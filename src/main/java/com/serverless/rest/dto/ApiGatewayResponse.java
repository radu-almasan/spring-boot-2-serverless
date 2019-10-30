package com.serverless.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;


@Data
@Builder
public class ApiGatewayResponse<T> {

    private final int statusCode;
    private final T body;
    private final Map<String, String> headers;
    private final boolean isBase64Encoded;

    // API Gateway expects the property to be called "isBase64Encoded" => isIs
    public boolean isIsBase64Encoded() {
        return isBase64Encoded;
    }

}
