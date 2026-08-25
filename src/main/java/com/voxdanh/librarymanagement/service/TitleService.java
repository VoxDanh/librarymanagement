package com.voxdanh.librarymanagement.service;


import com.voxdanh.librarymanagement.repository.BookRepository;
import com.voxdanh.librarymanagement.repository.TitleRepository;
import com.voxdanh.librarymanagement.model.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TitleService {
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private BookRepository bookRepository;

    //them tac pham
    public Long addTitle(String name, String author, LocalDate releaseDate,String publisher){
        Title addTitle= new Title();
        addTitle.setName(name);
        addTitle.setAuthor(author);
        addTitle.setReleaseDate(releaseDate);
        addTitle.setPublisher(publisher);
        Title saveTitle=titleRepository.save(addTitle);
        return saveTitle.getId();
    }

    //xoa tac pham
    public void deleteTitle(Long id){
        titleRepository.deleteById(id);
    }
    //cap nhat tac pham
    public Title updateNameById(Long id,String name){
        Title title=titleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong co sach hop le"));
        title.setName(name);
        Title updateTitle=titleRepository.save(title);
        return updateTitle;
    }
    public Title updateAuthorById(Long id,String author){
        Title title=titleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong co sach hop le"));
        title.setAuthor(author);
        Title updateTitle=titleRepository.save(title);
        return updateTitle;
    }
    public Title updatePublisherById(Long id,String publisher){
        Title title=titleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong co sach hop le"));
        title.setPublisher(publisher);
        Title updateTitle=titleRepository.save(title);
        return updateTitle;
    }
    public Title updateReleaseDateById(Long id,LocalDate releaseDate){
        Title title=titleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong co sach hop le"));
        title.setReleaseDate(releaseDate);
        Title updateTitle=titleRepository.save(title);
        return updateTitle;
    }
    //truy van tac pham
    public List<Title> allTilte(){
        return titleRepository.findAll();
    }
    public List<Title> findTitleByName(String name){
        return titleRepository.findByName(name);
    }
    public List<Title> findTitleByAuthor(String author){
        return titleRepository.findByAuthor(author);
    }
    public List<Title> findTitleByPublisher(String publisher){
        return titleRepository.findByPublisher(publisher);
    }
    public List<Title> findTitleByReleaseDateBetween(LocalDate start,LocalDate end){
        return titleRepository.findByReleaseDateBetween(start,end);
    }






}
