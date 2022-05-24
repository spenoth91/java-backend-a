package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.OrderItem;
import com.msglearning.javabackend.to.OrderItemTO;

public class OrderItemConverter {

    public static final OrderItemTO convertToTO(OrderItem entity) {
        return OrderItemTO.builder()
                .id(entity.getId())
                .foodId(entity.getFood().getId())
                .amount(entity.getAmount())
                .price(entity.getPrice())
                .build();
    }
    public static final OrderItem convertToEntity(OrderItemTO to) {
        return OrderItem.builder()
                .amount(to.getAmount())
                .build();
    }

}
