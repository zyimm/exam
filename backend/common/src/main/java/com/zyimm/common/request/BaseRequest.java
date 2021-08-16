package com.zyimm.common.request;

import lombok.Data;

/**
 * @author zyimm
 */
@Data
abstract class BaseRequest {
    
    public Long page;

    public Long  limit;

}
