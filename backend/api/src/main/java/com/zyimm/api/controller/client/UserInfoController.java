package com.zyimm.api.controller.client;

import com.zyimm.common.response.Response;
import com.zyimm.dao.dto.UserDto;
import com.zyimm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author zyimm
 */
@RestController

public class UserInfoController extends BaseController{

    @Autowired
    private UserService userService;

    @GetMapping("/user/user")
    public Response userInfo(){
        UserDto result = userService.getUserInfoById(getLoginId());
        return Response.success(result);
    }
}
