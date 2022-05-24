package com.msglearning.javabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = OrderItem.TABLE_NAME)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    static final String TABLE_NAME = "order_items";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="order_items_id")
    private Long id;

    @ManyToOne
    @JoinColumn (name= "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn (name="food_id")
    private Food food;

    @Column
    private Integer amount;

    @Column
    private BigDecimal price;

}

