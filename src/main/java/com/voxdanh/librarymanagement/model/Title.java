package com.voxdanh.librarymanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Table(name="Titles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="author",nullable=false)
    private String author;
    @Column(name="release_date",nullable=false)
    private LocalDate releaseDate;
    @Column(name="publisher",nullable=false)
    private String publisher;
}
