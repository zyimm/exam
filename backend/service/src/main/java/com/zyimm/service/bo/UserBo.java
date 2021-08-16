package com.zyimm.service.bo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyimm.dao.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyimm
 */
@Component
public class UserBo {
    public Map<String, Object> userList(IPage<UserEntity> userList){
        Map<String, Object> map  = new  HashMap<>(2);
        map.put("data", userList.getRecords());
        
        Map<String, Object> pageInfo  = new HashMap<>(4);
        pageInfo.put("page", userList.getCurrent());
        pageInfo.put("page_size", userList.getSize());
        pageInfo.put("total", userList.getTotal());
        map.put("page_info", pageInfo);
        return map;
    }
}
