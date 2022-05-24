package com.msglearning.javabackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = User.TABLE_NAME)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

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

    @Column
    private Boolean admin;

}
