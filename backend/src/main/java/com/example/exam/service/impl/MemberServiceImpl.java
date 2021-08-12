package com.example.exam.service.impl;

import java.util.HashMap;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.exam.controller.request.MemberRequest;
import com.example.exam.entity.Member;
import com.example.exam.mapper.MemberMapper;
import com.example.exam.service.MemberService;
import com.example.exam.service.bo.MemberBo;
import com.example.exam.service.query.QueryBuild;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author zyimm
 */
@Component
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    QueryWrapper<Member> queryWrapper;

    MemberBo memberBo;

  
    Member member;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Member getMemberInfoById(String id) {
        
        return memberMapper.selectById(id);
    }

    @Autowired
    public void setMemberBo(MemberBo memberBo) {
        this.memberBo = memberBo;
    }

     /**
     * 查询配置
     *
     * @return Map map
     */
    public Map<String, String> condition() {
        Map<String, String> map = new HashMap<>(2);
        map.put("likeRight", "member_name@getStoreInfo");
        return map;
    }


    @Override
    public Map<String, Object> getMemberList(MemberRequest memberRequest) {
        this.queryWrapper = new  QueryWrapper<>();
        this.queryWrapper = new QueryBuild<Member, MemberRequest>().buildQuery(this.queryWrapper, this.condition(), memberRequest);
        IPage<Member> page = new Page<>(memberRequest.getPage(), memberRequest.getLimit());
        this.queryWrapper.orderByDesc("id");
        IPage<Member> listMember =  memberMapper.selectPage(page, this.queryWrapper);
        return  this.memberBo.memberList(listMember);
    }

    @Override
    public String insertMember(Member member) {
    
        return "";
    }

    @Override
    public String insertMemberForRequest(MemberRequest memberRequest) {
        this.member = new Member();
        BeanUtils.copyProperties(memberRequest, this.member);
        return String.valueOf(this.memberMapper.insert(this.member));
    }
    
}
