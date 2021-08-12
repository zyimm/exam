package com.example.exam.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberRequest extends BaseRequest {

    private String memberName;

}
