package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.entity.OrderStatus;
import com.msglearning.javabackend.services.OrderService;
import com.msglearning.javabackend.to.FoodTO;
import com.msglearning.javabackend.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_ORDER })
public class OrderController {

    private static final String ALL_PATH = "/all";
    private static final String ID_PATH = "/{id}";
    private static final String STATUS_PATH = "/{id}/status";

    @Autowired
    OrderService orderService;


    @GetMapping
    public List<OrderTO> getAll() {
        return orderService.findAll();
    }


    @GetMapping(ID_PATH)
    public Optional<OrderTO> getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderTO addOrder(@RequestBody OrderTO orderTO){
        return orderService.save(orderTO);
    }

    @PutMapping(STATUS_PATH)
    public void updateStatus(@PathVariable long id, @RequestBody OrderStatus status) {orderService.updateStatus(id, status);}
}


