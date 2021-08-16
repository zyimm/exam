package com.zyimm.api.controller.server;

import java.util.Map;

import com.zyimm.common.request.UserRequest;
import com.zyimm.common.response.Response;
import com.zyimm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyimm
 */
@RestController
public class UserContrpller {


    @Autowired
    private UserService  userService;

    @GetMapping("/user/users")
    public Response getMembers(UserRequest userRequest){
        Map<String, Object> result = userService.getUserList(userRequest);
        return Response.success(result);
    }
}