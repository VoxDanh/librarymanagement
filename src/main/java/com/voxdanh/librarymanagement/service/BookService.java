package com.voxdanh.librarymanagement.service;


import com.voxdanh.librarymanagement.model.Book;
import com.voxdanh.librarymanagement.model.Title;
import com.voxdanh.librarymanagement.repository.BookRepository;
import com.voxdanh.librarymanagement.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TitleRepository titleRepository;
    //cap nhat so luong sach cho 1 title
    public int addNumberOfBook(Long id,int number){
        Title title=titleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("khong tim thay sach"));
        int count=0;
        for(int i=1;i<=number;i++){
            Book book=new Book();
            book.setTitle(title);
            book.setStatus(true);
            Book saveBook=bookRepository.save(book);
            count+=1;
        }
        return count;
    }
    //xoa sach theo id
    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }




}
