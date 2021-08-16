package com.zyimm.common.request;



import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRequest  extends BaseRequest{

    private UserMainRequest main;

    private UserInfoRequest info; 
    
}
