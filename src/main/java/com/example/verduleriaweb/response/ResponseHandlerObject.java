package com.example.verduleriaweb.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandlerObject {

    public static ResponseEntity<Object> responseBuilder(String messsage, HttpStatus httpStatus, Object responseObject){
        Map<String, Object> response = new HashMap<>();

        response.put("message", messsage);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }
}
