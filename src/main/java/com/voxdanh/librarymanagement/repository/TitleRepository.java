package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface  TitleRepository extends JpaRepository<Title,Long> {
    List<Title> findByNameContainingIgnoreCase(String name);
    List<Title> findByAuthorContainingIgnoreCase(String author);
    List<Title> findByPublisherContainingIgnoreCase(String publisher);
    List<Title> findByReleaseDateBetween(LocalDate startDate,LocalDate endDate);
}
