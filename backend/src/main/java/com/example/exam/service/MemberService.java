package com.example.exam.service;

import java.util.Map;

import com.example.exam.controller.request.MemberRequest;
import com.example.exam.entity.Member;

/**
 * @author  zyimm
 */
public interface MemberService {

    /**
     * 根据id获取会员信息
     * 
     * @param id
     * @return
     */
    public Member getMemberInfoById(String id);


    /**
     * 获取会员列表
     * 
     * @param  memberRequest
     * @return Map<String, Object>
     */
    public Map<String, Object> getMemberList(MemberRequest memberRequest);


    /**
     * 
     * 新增会员
     * 
     * @param member
     * @return 
     */
    public String insertMember(Member member);

    /**
     * 
     * 新增会员
     * 
     * @param member
     * @return 
     */
    public String insertMemberForRequest(MemberRequest member);

    
}
