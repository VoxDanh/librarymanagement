package com.voxdanh.librarymanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="Loan_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetail {
    @EmbeddedId
    private LoanDetailId id;
    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("IdLoanRecord")
    @JoinColumn(name="id_loanRecord")
    private LoanRecord loanRecord;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("IdBook")
    @JoinColumn(name="id_book")
    private Book book;
    @Column(name="return_date")
    private LocalDate returnDate;
    @Column(name="due_date",nullable=false)
    private LocalDate dueDate;
    @Column(name="return_status",nullable=false)
    private Boolean returnStatus;
    @Column(name = "note")
    private String note;
}
