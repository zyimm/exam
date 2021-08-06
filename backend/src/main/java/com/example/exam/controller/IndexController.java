package com.example.exam.controller;

import com.example.exam.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public Response index(){
        return Response.success("hello");
    }
}
