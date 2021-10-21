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
public class UserInfoDto {

    private Long id;

    private Long userId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
    
    private String updatedUid;

    private LocalDateTime updatedAt;
}
