package com.example.exam.controller;

import java.util.Map;

import com.example.exam.common.response.Response;
import com.example.exam.controller.request.MemberRequest;
import com.example.exam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZYIMM
 */
@RestController
public class MemberController {
    
    @Autowired
    MemberService memberService;
    

    @GetMapping("/member/members")
    public Response getMembers(MemberRequest memberRequest){
        Map<String, Object> result = memberService.getMemberList(memberRequest);
        return Response.success(result);
    }

    @PostMapping("/member/member")
    public Response add(MemberRequest memberRequest){
        Map<String, Object> result = memberService.insertMemberForRequest(memberRequest);
        return Response.success(result);
    }
}
