package com.example.exam.service.bo;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.exam.entity.Member;

import org.springframework.stereotype.Component;

/**
 * @author zyimm
 */
@Component
public class MemberBo {
    

    public Map<String, Object> memberList(IPage<Member> memberList){
        Map<String, Object> map  = new  HashMap<>(2);
        map.put("data", memberList.getRecords());
        
        Map<String, Object> pageInfo  = new HashMap<>(4);
        pageInfo.put("page", memberList.getCurrent());
        pageInfo.put("page_size", memberList.getSize());
        pageInfo.put("total", memberList.getTotal());
        map.put("page_info", pageInfo);
        return map;
    }
}
