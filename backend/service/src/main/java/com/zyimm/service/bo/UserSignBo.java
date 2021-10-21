package com.zyimm.service.bo;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

/**
 * @author zyimm
 */
@Builder
@Data
public class UserSignBo {

    private String  userId;

    private String accessToken;

    private Integer expireIn;

}
