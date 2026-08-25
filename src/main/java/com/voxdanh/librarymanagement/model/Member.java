package com.voxdanh.librarymanagement.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name="Members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column ( name="full_name",nullable=false)
    private String fullName;
    @Column(name="birth_date",nullable=false)
    private LocalDate birthDate;
    @Column (name="gender",nullable=false)
    private Boolean gender; //1-Male 0-Female
    @Column (name="phone",nullable=false,unique=true,length=11)
    private String phone;
    @Column (name="email",nullable=false,unique=true)
    private String email;
}
