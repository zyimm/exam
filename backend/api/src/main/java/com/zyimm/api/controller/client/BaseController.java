package com.zyimm.api.controller.client;

import cn.dev33.satoken.stp.StpUtil;

/**
 * @author ZYIMM
 */
public class BaseController {

    public Long getLoginId(){
        return Long.valueOf((String) StpUtil.getLoginId());
    }
}
