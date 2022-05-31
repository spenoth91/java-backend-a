package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.services.FoodService;
import com.msglearning.javabackend.to.FoodTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_FOOD })
public class FoodController {

    private static final String ID_PATH = "/{id}";
    private static final String AVAILABILITY_PATH = "/{id}/availability";

    @Autowired
    FoodService foodService;

    @Autowired
    private Environment env;


    @GetMapping
    public List<FoodTO> getAll() {
        return foodService.findAll();
    }


    @GetMapping(ID_PATH)
    public Optional<FoodTO> getById(@PathVariable Long id) {
        return foodService.findById(id);
    }

    @PostMapping
    public FoodTO addFood(@RequestBody FoodTO foodTO){
        return foodService.save(foodTO);
    }

    @PutMapping(ID_PATH)
    public FoodTO update(@PathVariable Long id,@RequestBody FoodTO foodTO){
        return foodService.update(id, foodTO);
    }

    @DeleteMapping(ID_PATH)
    public void delete(@PathVariable Long id) {foodService.delete(id);}

    @PutMapping(AVAILABILITY_PATH)
    public void updateAvailability(@PathVariable long id, @RequestBody boolean availability) {foodService.updateAvailability(id, availability);}
}
