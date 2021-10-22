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
public class UserInfoDto {

    private Long id;

    private Long userId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
    
    private String updatedUid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
