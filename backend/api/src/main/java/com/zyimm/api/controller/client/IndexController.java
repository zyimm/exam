package com.zyimm.api.controller.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyimm
 */
@RestController
public class IndexController {
    
    @GetMapping("/hi")
    public String hello(){
        return "hi";
    }
}
