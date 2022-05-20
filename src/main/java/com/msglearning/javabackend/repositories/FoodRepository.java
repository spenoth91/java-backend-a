package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long > {
    List<Food> findAll();

    Optional<Food> findById(Long id);



}
