package com.voxdanh.librarymanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name="loan_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="loan_day",nullable=false)
    private LocalDate loanDay;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_member",nullable=false)
    private Member member;

}
