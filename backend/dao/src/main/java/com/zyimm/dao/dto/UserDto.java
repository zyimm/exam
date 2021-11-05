package com.zyimm.dao.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)

public class UserDto  {

    private Long id;

    private String userName;

    private String userNickname;

    private String userAvatar;

    private String userStatus;

    private Integer userSex;

    private String userMobile;

    private String userEmail;

    private String lastLoginIp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

    private String updatedUid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    private UserInfoDto info;
}
