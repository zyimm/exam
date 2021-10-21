package com.zyimm.service;

import com.zyimm.common.request.UserQueryRequest;
import com.zyimm.common.request.UserRequest;
import com.zyimm.dao.dto.UserDto;
import com.zyimm.dao.entity.UserEntity;
import java.util.Map;

/**
 * @author zyimm
 */
public interface UserService {

     /**
     * 根据id获取会员信息
     * 
     * @param id 会员id
     * @return UserDto
     */
     UserDto getUserInfoById(Long id);


    /**
     * 获取会员列表
     * 
     * @param  userRequest 请求参数
     * @return Map<String, Object>
     */
    Map<String, Object> getUserList(UserQueryRequest userRequest);


    /**
     * 
     * 新增会员
     * 
     * @param userEntity 用户实体
     * @return  String
     */
    String insertUser(UserEntity userEntity);

    /**
     * 
     * 新增会员
     * 
     * @param user 提交参数
     * @return Map<String, Object>
     */
    Map<String, Object> insertUserForRequest(UserRequest user);
    
}
