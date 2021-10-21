package com.zyimm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyimm.common.exception.ExamException;
import com.zyimm.common.request.SignRequest;
import com.zyimm.common.utils.PasswordCrypt;
import com.zyimm.dao.entity.UserEntity;
import com.zyimm.dao.mapper.UserMapper;
import com.zyimm.service.SignService;
import com.zyimm.service.bo.UserSignBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.dev33.satoken.stp.StpUtil;

/**
 * @author zyimm
 */
@Component
public class SignServiceImpl implements SignService{


    @Autowired
    UserMapper userMapper;


    @Override
    public UserSignBo in(SignRequest request) {
        QueryWrapper<UserEntity> queryMapper = new QueryWrapper<>();
        queryMapper.eq("user_name", request.getAccount());
        UserEntity userInfo = userMapper.selectOne(queryMapper);
        if (userInfo != null && this.checkPassword(request.getPassword(), userInfo.getUserPassword())) {
            StpUtil.login(userInfo.getId());
            return UserSignBo.builder()
            .accessToken(StpUtil.getTokenInfo().getTokenValue())
            .expireIn(3600)
            .userId(String.valueOf(userInfo.getId())).build();    
        }
        throw new ExamException("登录失败");
    }

    private  Boolean checkPassword(String password, String ciphertext)
    {
        return  PasswordCrypt.hashVerify(password, ciphertext);
    }

}
