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
public class UserInfoRequest extends BaseRequest{

    private String userId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
}
