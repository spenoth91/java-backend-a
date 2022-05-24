package com.msglearning.javabackend.services;

import com.msglearning.javabackend.converters.OrderConverter;
import com.msglearning.javabackend.converters.OrderItemConverter;
import com.msglearning.javabackend.entity.*;
import com.msglearning.javabackend.exceptionhandling.NotFoundException;
import com.msglearning.javabackend.repositories.FoodRepository;
import com.msglearning.javabackend.repositories.OrderItemRepository;
import com.msglearning.javabackend.repositories.OrderRepository;
import com.msglearning.javabackend.repositories.UserRepository;
import com.msglearning.javabackend.to.OrderItemTO;
import com.msglearning.javabackend.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    FoodRepository foodRepository;

    @Transactional
    public OrderTO save(OrderTO orderTO) {
        // map order
        Order order = OrderConverter.convertToEntity(orderTO);
        //search for user
        User user = userRepository.findById(orderTO.getUserId())
                .orElseThrow(() -> new NotFoundException("User with id " + orderTO.getUserId() + " not found"));
        order.addUser(user);
        order.setOrderTime(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);
        order.setTotalPrice(BigDecimal.ZERO);

        orderRepository.save(order);

        for (OrderItemTO orderItemTO : orderTO.getOrderItems()) {

            OrderItem orderItem = OrderItemConverter.convertToEntity(orderItemTO);
            order.addOrderItem(orderItem);

            Food food = foodRepository.findById(orderItemTO.getFoodId())
                    .orElseThrow(() -> new NotFoundException("Food with id " + orderItemTO.getFoodId() + " not found"));
            food.addOrderItem(orderItem);
            orderItem.setPrice(food.getPrice());
            orderItemRepository.save(orderItem);
            order.setTotalPrice(order.getTotalPrice().add(food.getPrice().multiply(BigDecimal.valueOf(orderItemTO.getAmount()))));

        }
        orderRepository.save(order);

        return OrderConverter.convertToTO(order);
    }


    public List<OrderTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty())
            return Collections.emptyList();
        else
            return orders.stream()
                    .map(OrderConverter::convertToTO)
                    .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Food with id " + id + " not found"));

        orderRepository.delete(order);
    }


    public Optional<OrderTO> findById(Long id) {
        return orderRepository.findById(id)
                .map(OrderConverter::convertToTO);

    }

    public void updateStatus(long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order with id " + id + " not found"));

        order.setStatus(status);
        orderRepository.save(order);
    }



/*
    public OrderTO modify(Long id, OrderTO orderTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food with id "+id+" not found"));

        mapOrderTO(orderTO, order);

        orderRepository.save(order);

        return OrderConverter.convertToTO(order);
    }
    /*
    private void mapOrderTO(OrderTO orderTO, Order order) {
        order.setUser(orderTO.getUser());
        order.setOrderTime(orderTO.getOrderTime());
        order.setOrderAddress(orderTO.getOrderAddress());
        order.setStatus(orderTO.getStatus());
        order.setTotalPrice(orderTO.getTotalPrice());

    }
    */

}
