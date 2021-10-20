package com.zyimm.api.controller.client;

import java.util.HashMap;
import java.util.Map;
import com.zyimm.common.request.SignRequest;
import com.zyimm.common.response.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.dev33.satoken.stp.StpUtil;

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
        Map<String, Object> result = new HashMap<>(4);
        StpUtil.login("10001");
        result.put("token", StpUtil.getTokenInfo()); 
        return Response.success(result);
    }
}
