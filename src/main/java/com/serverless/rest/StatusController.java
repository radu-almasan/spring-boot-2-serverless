package com.serverless.rest;

import com.amazonaws.services.lambda.runtime.Context;
import com.serverless.rest.dto.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("status")
@RequiredArgsConstructor
@Slf4j
public class StatusController {

    private final Context context;

    @GetMapping
    public ResponseEntity<Response> handleRequest(Map<String, Object> input) {
        log.info("received input: {}, context: {}, remaining ms: {}", input, context, context.getRemainingTimeInMillis());

        Response responseBody = new Response("Go Serverless v1.x! Your function executed successfully!", input);
        return ResponseEntity.status(OK)
                .header("X-Powered-By", "AWS Lambda & serverless")
                .body(responseBody);
    }

}
