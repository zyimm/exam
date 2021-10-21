package com.zyimm.service;

import com.zyimm.common.request.SignRequest;
import com.zyimm.service.bo.UserSignBo;

/**
 * @author zyimm
 */
public interface SignService {
    
    /**
     * 登录
     * 
     * @param request
     * @return
     */
    public UserSignBo in(SignRequest request);
}
