package com.msglearning.javabackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = User.TABLE_NAME)
@Entity
public class User {

    static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true,
            nullable = false)
    private String email;

    @Column(unique = true,
            nullable = false)
    private String phone;

    @Column
    private String profileImage;

    @Column
    private String occupation;


}
