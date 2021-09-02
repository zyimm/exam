package com.zyimm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyimm.dao.entity.UserEntity;


/**
 * @author zyimm
 */
public interface  UserMapper extends BaseMapper<UserEntity>{


     /**
      * 获取会员信息
      * 
      * @param id 会员id
      * @return
      */
    public UserEntity getUserInfoById(Long id);
    
}
