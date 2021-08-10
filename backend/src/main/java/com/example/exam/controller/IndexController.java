package com.example.exam.controller;

import com.example.exam.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZYIMM
 */
@RestController
public class IndexController {

    @GetMapping("/hello")
    public Response index(){
        return Response.success("hello");
    }

    @GetMapping("/error-not")
    public Response error(){
        return Response.fail("error");
    }

}
