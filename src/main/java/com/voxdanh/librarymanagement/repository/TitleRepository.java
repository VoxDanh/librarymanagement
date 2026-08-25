package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  TitleRepository extends JpaRepository<Title,Long> {

}
