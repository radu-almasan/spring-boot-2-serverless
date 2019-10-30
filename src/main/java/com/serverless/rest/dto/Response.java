package com.serverless.rest.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Response {

	private final String message;
	private final Map<String, Object> input;

}
