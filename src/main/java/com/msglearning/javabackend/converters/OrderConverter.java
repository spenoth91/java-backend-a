package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.Order;
import com.msglearning.javabackend.to.OrderTO;

public class OrderConverter {

    public static final OrderTO convertToTO(Order entity) {
        return new OrderTO(entity.getId(), entity.getUser(),
                entity.getOrderTime(), entity.getOrderAddress(), entity.getStatus(), entity.getTotalPrice());
    }

}
