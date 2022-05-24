package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.Order;
import com.msglearning.javabackend.to.OrderTO;

public class OrderConverter {

    public static final OrderTO convertToTO(Order entity) {
        return OrderTO.builder()
                .id(entity.getId())
                .orderTime(entity.getOrderTime())
                .orderAddress(entity.getOrderAddress())
                .status(entity.getStatus())
                .totalPrice(entity.getTotalPrice())
                .build();
    }
    public static final Order convertToEntity(OrderTO to) {
        return Order.builder()
                .orderAddress(to.getOrderAddress())
                .build();
    }

}
