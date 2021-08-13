package com.example.exam.controller.request;

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
public class MemberInfoRequest  extends BaseRequest{

    private String memberId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
}
