package com.voxdanh.librarymanagement.service;
import java.time.LocalDate;
import com.voxdanh.librarymanagement.model.*;
import com.voxdanh.librarymanagement.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LoanService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LoanRecordRepository loanRecordRepository;
    @Autowired
    private LoanDetailRepository loanDetailRepository;

    public LoanRecord recordBorrow(Member member, List<Book> bookList){
        LoanRecord returnRecord=new LoanRecord();
        returnRecord.setLoanDay(LocalDate.now());
        returnRecord.setMember(member);
        returnRecord=loanRecordRepository.save(returnRecord);
        for(Book book: bookList){
            if(!book.getStatus()){
                throw new IllegalStateException("Sach khong the muon " + book.getId());
            }
            else{
                LoanDetail detail=new LoanDetail();
                detail.setLoanRecord(returnRecord);
                detail.setBook(book);
                detail.setDueDate(returnRecord.getLoanDay().minusWeeks(2));
                detail.setReturnDate(null);
                detail.setReturnStatus(false);
                detail.setNote("");
                loanDetailRepository.save(detail);
                book.setStatus(false);
                bookRepository.save(book);

            }

        }
        return returnRecord;
    }


}
