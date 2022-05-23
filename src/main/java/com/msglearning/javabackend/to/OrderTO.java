package com.msglearning.javabackend.to;

import com.msglearning.javabackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderTO implements Serializable {

    private Long id;

    private User user;

    private LocalDateTime orderTime;

    private String orderAddress;

    private String status;

    private BigDecimal totalPrice;
}
