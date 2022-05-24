package com.msglearning.javabackend.to;

import com.msglearning.javabackend.entity.OrderStatus;
import com.msglearning.javabackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class OrderTO implements Serializable {

    private Long id;

    private Long userId;

    private List<OrderItemTO> orderItems= new ArrayList<>();

    private LocalDateTime orderTime;

    private String orderAddress;

    private OrderStatus status;

    private BigDecimal totalPrice;
}
