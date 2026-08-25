package com.voxdanh.librarymanagement.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="status",nullable=false)
    private Boolean status;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_title",nullable=false)
    private Title title;

}
