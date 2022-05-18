package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long > {


}
