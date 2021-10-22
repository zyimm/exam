package com.zyimm.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYIMM
 */
public class Page {

    public static Map<String, Object>  render(IPage o) {
        Map<String, Object> pageInfo  = new HashMap<>(3);
        pageInfo.put("page", o.getCurrent());
        pageInfo.put("page_size", o.getSize());
        pageInfo.put("total", o.getTotal());
        return pageInfo;
    }
}
