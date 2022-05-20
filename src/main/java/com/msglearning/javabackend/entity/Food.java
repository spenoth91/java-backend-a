package com.msglearning.javabackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = Food.TABLE_NAME)
@Entity
public class Food {

    static final String TABLE_NAME = "food";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="food_id")
    private Long id;

    @Column (name= "food_name")
    private String foodName;

    @Column
    private Integer calories;

    @Column
    private String ingredients;

    @Column
    private BigDecimal price;

    @Column (name= "food_image")
    private String foodImage;

    @Column
    private Boolean availability;

}

