package com.zyimm.service;

import java.util.Map;
import com.zyimm.common.request.UserRequest;
import com.zyimm.dao.entity.UserEntity;

/**
 * @author zyimm
 */
public interface UserService {

     /**
     * 根据id获取会员信息
     * 
     * @param id
     * @return
     */
    public UserEntity getUserInfoById(String id);


    /**
     * 获取会员列表
     * 
     * @param  userRequest
     * @return Map<String, Object>
     */
    public Map<String, Object> getUserList(UserRequest userRequest);


    /**
     * 
     * 新增会员
     * 
     * @param userEntity
     * @return 
     */
    public String insertUser(UserEntity userEntity);

    /**
     * 
     * 新增会员
     * 
     * @param user
     * @return 
     */
    public Map<String, Object> insertUserForRequest(UserRequest user);
    
}
