package com.msglearning.javabackend.services;

import com.msglearning.javabackend.converters.OrderConverter;
import com.msglearning.javabackend.entity.Order;
import com.msglearning.javabackend.exceptionhandling.NotFoundException;
import com.msglearning.javabackend.repositories.OrderRepository;
import com.msglearning.javabackend.to.OrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public OrderTO save(OrderTO orderTO){

        Order order=new Order();
        mapOrderTO(orderTO, order);

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

    public void delete(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food with id "+id+" not found"));

        orderRepository.delete(order);
    }


    public Optional<OrderTO> findById(Long id) {
        return orderRepository.findById(id)
                .map(OrderConverter::convertToTO);

    }


    public OrderTO modify(Long id, OrderTO orderTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Food with id "+id+" not found"));

        mapOrderTO(orderTO, order);

        orderRepository.save(order);

        return OrderConverter.convertToTO(order);
    }

    private void mapOrderTO(OrderTO orderTO, Order order) {
        order.setUser(orderTO.getUser());
        order.setOrderTime(orderTO.getOrderTime());
        order.setOrderAddress(orderTO.getOrderAddress());
        order.setStatus(orderTO.getStatus());
        order.setTotalPrice(orderTO.getTotalPrice());

    }
}
