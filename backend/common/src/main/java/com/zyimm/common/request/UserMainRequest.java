package com.zyimm.common.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class UserMainRequest extends BaseRequest{

    private String userName;

    private String userNickname;

    private String userAvatar;

    private Integer userSex;
    
}
