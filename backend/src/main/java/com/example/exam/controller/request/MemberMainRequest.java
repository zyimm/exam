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
public class MemberMainRequest  extends BaseRequest{

    private String memberName;

    private String memberNickname;

    private String memberAvatar;

    private Integer memberSex;
}
