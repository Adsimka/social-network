package com.adsima.spring.http.controller.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.adsima.spring.http.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
