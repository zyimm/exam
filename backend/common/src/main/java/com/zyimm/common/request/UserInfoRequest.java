package com.zyimm.common.request;

import lombok.Data;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class UserInfoRequest extends BaseRequest{

    private String userId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
}
