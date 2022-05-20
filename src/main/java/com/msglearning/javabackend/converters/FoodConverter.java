package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.Food;
import com.msglearning.javabackend.to.FoodTO;

public class FoodConverter {

    public static final FoodTO convertToTO(Food entity) {
        return new FoodTO(entity.getId(), entity.getFoodName(),
                entity.getCalories(), entity.getIngredients(), entity.getPrice(), entity.getAvailability());
    }

}
