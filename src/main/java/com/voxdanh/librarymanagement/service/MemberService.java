package com.voxdanh.librarymanagement.service;

import com.voxdanh.librarymanagement.model.Member;
import com.voxdanh.librarymanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    public Member addMember(String name, LocalDate birthDate,Boolean gender,String phone,String email){
        Member newMember=new Member();
        newMember.setFullName(name);
        newMember.setBirthDate(birthDate);
        newMember.setGender(gender);
        newMember.setPhone(phone);
        newMember.setEmail(email);
        newMember=memberRepository.save(newMember);
        return newMember;
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }



    public List<Member> findByName(String name){
        return memberRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Member> findByEmail(String email){
        return memberRepository.findByEmailContainingIgnoreCase(email);
    }
    public List<Member> findByPhone(String phone){
        return memberRepository.findByPhoneContainingIgnoreCase(phone);
    }
    public List<Member> findByGender(Boolean gender){
        return memberRepository.findByGender(gender);
    }
    public List<Member> findByBirthDateBetween(LocalDate start,LocalDate end){
        return memberRepository.findByBirthDateBetween(start,end);
    }
}
