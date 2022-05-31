package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class FoodTO implements Serializable {

    private Long id;

    private String foodName;

    private Integer calories;

    private String ingredients;

    private BigDecimal price;

    private String foodImage;

    private Boolean availability;
}
