package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import com.voxdanh.librarymanagement.model.Title;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    int countByTitle(Long title);
    void deleteAllbyTitle(Long title);
    Optional<Book> findById(Long book);
    List<Book>findByTitle(Long title);
}
