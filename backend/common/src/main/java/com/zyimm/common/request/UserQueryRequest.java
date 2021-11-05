package com.zyimm.common.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;


/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
public class UserQueryRequest implements Serializable {
    
    private Long page  = 1L;

    private Long  limit = 10L;

    private String userName;

}
