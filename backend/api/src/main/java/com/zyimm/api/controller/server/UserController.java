package com.zyimm.api.controller.server;

import com.zyimm.common.request.UserQueryRequest;
import com.zyimm.common.request.UserRequest;
import com.zyimm.common.response.Response;
import com.zyimm.dao.dto.UserDto;
import com.zyimm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 用户列表
     *
     * @param userQueryRequest 查询参数
     * @return Response
     */
    @GetMapping("/user/users")
    public Response getMembers(UserQueryRequest userQueryRequest){
        Map<String, Object> result = userService.getUserList(userQueryRequest);
        return Response.success(result);
    }

    /**
     * 新增用户
     *
     * @param userRequest 查询参数
     * @return Response
     */
    @PostMapping("/user/user")
    public Response insertMembers(UserRequest userRequest){
        Map<String, Object> result = userService.insertUserForRequest(userRequest);
        return Response.success(result);
    }

    /**
     *  用户列表
     *
     * @param id 会员id
     * @return Response
     */
    @GetMapping("/user/user/{id}")
    public Response getMember(@PathVariable("id") Long id){
        UserDto result = userService.getUserInfoById(id);
        return Response.success(result);
    }
}