package com.msglearning.javabackend.entity;

import ch.qos.logback.core.BasicStatusManager;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = Food.TABLE_NAME)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    static final String TABLE_NAME = "food";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="food_id")
    private Long id;

    @Builder.Default
    @OneToMany (mappedBy = "food")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column (name= "food_name")
    private String foodName;

    @Column
    private Integer calories;

    @Column
    private String ingredients;

    @Column
    private BigDecimal price;

    @Column (name= "food_image")
    private String foodImage;

    @Column
    private Boolean availability;

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.setFood(this);
    }

}

