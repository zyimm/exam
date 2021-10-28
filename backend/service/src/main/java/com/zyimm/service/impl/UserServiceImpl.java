package com.zyimm.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyimm.common.exception.ExamException;
import com.zyimm.common.request.UserQueryRequest;
import com.zyimm.common.request.UserRequest;
import com.zyimm.dao.dto.UserDto;
import com.zyimm.dao.entity.UserEntity;
import com.zyimm.dao.entity.UserInfoEntity;
import com.zyimm.dao.mapper.UserInfoMapper;
import com.zyimm.dao.mapper.UserMapper;
import com.zyimm.service.UserService;
import com.zyimm.service.bo.UserBo;
import com.zyimm.service.query.QueryBuild;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyimm
 */
@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    UserInfoMapper userInfoMapper;

    QueryWrapper<UserEntity> queryWrapper;

    UserBo userBo;

    UserEntity user;

    UserInfoEntity userInfo;

    @Autowired(required = false)
    public void setUserInfoMapper(UserInfoMapper userInfoMapper){
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserDto getUserInfoById(Long id) {
        return this.userBo.userInfo(baseMapper.getUserInfoById(id), new UserDto());
    }

    @Autowired
    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    /**
     * 查询配置
     *
     * @return Map map
     */
    public Map<String, String> condition() {
        Map<String, String> map = new HashMap<>(2);
        map.put("likeRight", "user_name@getUserName");
        return map;
    }

    @Override
    public Map<String, Object> getUserList(UserQueryRequest userRequest) {
        
        this.queryWrapper = new QueryBuild<UserEntity, UserQueryRequest>().
                    buildQuery(new QueryWrapper<>(), this.condition(), userRequest);
        IPage<UserEntity> page = new Page<>(userRequest.getPage(), userRequest.getLimit());
        this.queryWrapper.orderByDesc("id");
        IPage<UserEntity> listUser = baseMapper.selectPage(page, this.queryWrapper);
        listUser.setTotal(baseMapper.selectCount(this.queryWrapper));
        return this.userBo.userList(listUser);
    }

    @Override
    public String insertUser(UserEntity user) {

        return "";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> insertUserForRequest(UserRequest userRequest) {
        this.user = new UserEntity();
        this.userInfo = new UserInfoEntity();
        Log.get().info(userRequest.getMain().toString());
        BeanUtils.copyProperties(userRequest.getMain(), this.user);
        BeanUtils.copyProperties(userRequest.getInfo(), this.userInfo);
        if (!String.valueOf(baseMapper.insert(this.user)).isEmpty()) {
            this.userInfo.setUserId(this.user.getId());
            this.userInfoMapper.insert(this.userInfo);
            var result = new HashMap<String, Object>(1);
            result.put("user_id", this.user.getId());
            return result;
        }
        throw new ExamException("保存失败");
    }
}
