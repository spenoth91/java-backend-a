package com.msglearning.javabackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = Order.TABLE_NAME)
@Entity
public class Order {

    static final String TABLE_NAME = "orders";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn (name= "user_id")
    private User user;

    @Column (name="order_time")
    private LocalDateTime orderTime;

    @Column (name="order_adress")
    private String orderAddress;

    @Column
    private String status;

    @Column (name= "total_price")
    private BigDecimal totalPrice;

}

