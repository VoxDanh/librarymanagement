package com.voxdanh.librarymanagement.controller;


import com.voxdanh.librarymanagement.model.Member;
import com.voxdanh.librarymanagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController

public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("/member")
    public Member createMember(@RequestBody Member member){
        String name =member.getFullName();
        LocalDate birth=member.getBirthDate();
        Boolean gender=member.getGender();
        String phone=member.getPhone();
        String email=member.getEmail();
        return memberService.addMember(name,birth,gender,phone,email);
    }
    @DeleteMapping("/member/id")
    public void deleteById(Long id){
        memberService.deleteMember(id);
    }
    @GetMapping("/member")
    public List<Member> getAllMember(){
        return memberService.findAll();
    }
    @GetMapping("/member/name")
    public List<Member> getByName(String name){
        return memberService.findByName(name);
    }

}
