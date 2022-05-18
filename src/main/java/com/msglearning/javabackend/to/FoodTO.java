package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FoodTO implements Serializable {

    private Long id;

    private String foodName;

    private Integer calories;

    private String ingredients;

    private Float price;

    private Boolean availability;
}
