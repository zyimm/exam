package com.zyimm.api.controller.client;

import com.zyimm.common.request.SignRequest;
import com.zyimm.common.response.Response;
import com.zyimm.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * 登录
 * 
 * @author zyimm
 */
@RestController
public class SignController {



    private SignService signService;

    @Autowired
    public  void setSignService(SignService signService){
        this.signService = signService;
    }
    

    /**
     * 登录
     * 
     * @param signRequest
     * @return
     */
    @PostMapping("/user/signIn")
    public Response in(@RequestBody SignRequest signRequest) {
       
        return Response.success(signService.in(signRequest));
    }
}
