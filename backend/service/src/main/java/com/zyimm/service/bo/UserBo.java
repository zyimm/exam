package com.zyimm.service.bo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyimm.common.utils.PageRender;
import com.zyimm.dao.dto.UserDto;
import com.zyimm.dao.dto.UserInfoDto;
import com.zyimm.dao.dto.UserListDto;
import com.zyimm.dao.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyimm
 */
@Component
public class UserBo {


    private final UserListDto userListDto = new UserListDto();


    /**
     * 用户列表
     *
     *
     * @param userList 数据
     * @return Map<String, Object>
     */
    public Map<String, Object> userList(IPage<UserEntity> userList) {
        List<UserListDto> userDtoList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(2);
        for (UserEntity user : userList.getRecords()) {
            BeanUtils.copyProperties(user, this.userListDto);
            userDtoList.add(this.userListDto);
        }
        map.put("data", userDtoList.toArray());
        map.put("page_info", PageRender.render(userList));
        return map;
    }

    /**
     * userInfo
     *
     * @param userEntity 实体
     * @param userDto dto
     * @return UserDto
     */
    public UserDto userInfo(UserEntity userEntity, UserDto userDto) {
        BeanUtils.copyProperties(userEntity, userDto);
        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userEntity.getInfo(), userInfoDto);
        userDto.setInfo(userInfoDto);
        return userDto;
    }
}
