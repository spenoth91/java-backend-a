package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FoodTO implements Serializable {

    private Long id;

    private String foodName;

    private Integer calories;

    private String ingredients;

    private BigDecimal price;

    private Boolean availability;
}
