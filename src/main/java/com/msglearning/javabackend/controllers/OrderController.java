package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.services.OrderService;
import com.msglearning.javabackend.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_ORDER })
public class OrderController {

    private static final String ALL_PATH = "/all";
    private static final String ID_PATH = "/{id}";


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
}


