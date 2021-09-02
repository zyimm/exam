package com.zyimm.api.controller.server;

import com.zyimm.common.request.UserRequest;
import com.zyimm.common.response.Response;
import com.zyimm.dao.entity.UserEntity;
import com.zyimm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zyimm
 */
@RestController
public class UserController {


    @Autowired
    private UserService  userService;

    /**
     *  用户列表
     * 
     * @param userRequest
     * @return
     */
    @GetMapping("/user/users")
    public Response getMembers(UserRequest userRequest){
        Map<String, Object> result = userService.getUserList(userRequest);
        return Response.success(result);
    }


    /**
     *  用户列表
     * 
     * @param userRequest
     * @return
     */
    @GetMapping("/user/user/{id}")
    public Response getMember(@PathVariable("id") Long id){
    
        UserEntity result = userService.getUserInfoById(id);
        return Response.success(result);
    }


}