package com.voxdanh.librarymanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Embeddable
@Table(name = "loan_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LoanDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_loanRecord")
    private LoanRecord IdLoanRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book")
    private Book IdBook;
}

