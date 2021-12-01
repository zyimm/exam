package com.zyimm.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYIMM
 */
public class PageRender {

    /**
     *
     * @param page 分页对象
     * @return Map<String, Object>
     */
    public static Map<String, Object> render(IPage page) {
        Map<String, Object> pageInfo = new HashMap<>(3);
        pageInfo.put("page", page.getCurrent());
        pageInfo.put("page_size", page.getSize());
        pageInfo.put("total", page.getTotal());
        return pageInfo;
    }
}
