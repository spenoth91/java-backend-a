package com.msglearning.javabackend.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = Order.TABLE_NAME)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    static final String TABLE_NAME = "orders";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="order_id")
    private Long id;

    @ManyToOne ()
    @JoinColumn (name= "user_id")
    private User user;

    @Builder.Default
    @OneToMany (mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column (name="order_time")
    private LocalDateTime orderTime;

    @Column (name="order_adress")
    private String orderAddress;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column (name= "total_price")
    private BigDecimal totalPrice;

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void addUser(User user) {
        this.setUser(user);
        user.getOrders().add(this);
    }
}

