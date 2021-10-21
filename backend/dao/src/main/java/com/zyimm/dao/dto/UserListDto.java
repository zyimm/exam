package com.zyimm.dao.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.time.LocalDateTime;


/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
public class UserListDto {
    
    private Long id;

    private String userName;

    private String userNickname;

    private String userAvatar;

    private String userStatus;

    private Integer userSex;

    private String userMobile;

    private String userEmail;

    private String lastLoginIp;

    private LocalDateTime lastLoginTime;

    private String updatedUid;

    private LocalDateTime updatedAt;
}
