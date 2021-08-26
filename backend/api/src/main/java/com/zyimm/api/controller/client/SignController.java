package com.zyimm.api.controller.client;

import java.util.HashMap;
import java.util.Map;
import com.zyimm.common.request.SignRequest;
import com.zyimm.common.response.Response;
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

    /**
     * 登录
     * 
     * @param signRequest
     * @return
     */
    @PostMapping("/user/signIn")
    public Response in(@RequestBody SignRequest signRequest) {
        //映射
        Map<String, Object> result = new HashMap<>(4);
        return Response.success(result);
    }
}
