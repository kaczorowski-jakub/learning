package com.os.rest.test.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foos")
class FooController {
   
    
    @GetMapping
    public void test(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
    }
}