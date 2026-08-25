package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface  TitleRepository extends JpaRepository<Title,Long> {
    List<Title> findByName(String name);
    List<Title> findByAuthor(String author);
    List<Title> findByPublisher(String publisher);
    List<Title> findByReleaseDateBetween(LocalDate startDate,LocalDate endDate);
}
