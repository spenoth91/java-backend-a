package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.Food;
import com.msglearning.javabackend.to.FoodTO;

public class FoodConverter {

    public static final FoodTO convertToTO(Food entity) {
        return FoodTO.builder()
                .id(entity.getId())
                .foodName(entity.getFoodName())
                .calories(entity.getCalories())
                .ingredients(entity.getIngredients())
                .price(entity.getPrice())
                .foodImage(entity.getFoodImage())
                .availability(entity.getAvailability())
                .build();
    }

}
