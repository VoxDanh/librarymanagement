package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByFullNameContainingIgnoreCase(String name);
    List<Member> findByPhoneContainingIgnoreCase(String phone);
    List<Member> findByEmailContainingIgnoreCase(String email);
    List<Member> findByGender(Boolean gender);
    List<Member> findByBirthDateBetween(LocalDate start, LocalDate end);
}
