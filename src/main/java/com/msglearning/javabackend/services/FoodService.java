package com.msglearning.javabackend.services;

import com.msglearning.javabackend.converters.FoodConverter;
import com.msglearning.javabackend.entity.Food;
import com.msglearning.javabackend.exceptionhandling.NotFoundException;
import com.msglearning.javabackend.repositories.FoodRepository;
import com.msglearning.javabackend.to.FoodTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;


    public void updateAvailability (long id, boolean availability){
        Food food = foodRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food with id "+id+" not found"));

        food.setAvailability(availability);
        foodRepository.save(food);
    }


    public FoodTO save(FoodTO foodTO){

        Food food=new Food();
        mapFoodTO(foodTO, food);

        foodRepository.save(food);

        return FoodConverter.convertToTO(food);
    }


    public List<FoodTO> findAll() {
        List<Food> foods = foodRepository.findAll();
        if (foods.isEmpty())
            return Collections.emptyList();
        else
            return foods.stream()
                    .map(FoodConverter::convertToTO)
                    .collect(Collectors.toList());
    }

    public void delete(Long id){
        Food food = foodRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food with id "+id+" not found"));

        foodRepository.delete(food);
    }



    public Optional<FoodTO> findById(Long id) {
        return foodRepository.findById(id)
                .map(FoodConverter::convertToTO);

    }


    public FoodTO update(Long id, FoodTO foodTO) {
        Food food = foodRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food with id "+id+" not found"));

        mapFoodTO(foodTO, food);

        foodRepository.save(food);

        return FoodConverter.convertToTO(food);
    }

    private void mapFoodTO(FoodTO foodTO, Food food) {
        food.setFoodName(foodTO.getFoodName());
        food.setCalories(foodTO.getCalories());
        food.setIngredients(foodTO.getIngredients());
        food.setPrice(foodTO.getPrice());
        food.setAvailability(foodTO.getAvailability());
    }
}
