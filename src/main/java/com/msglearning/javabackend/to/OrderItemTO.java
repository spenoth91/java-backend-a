package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class OrderItemTO implements Serializable {

    private Long id;

    private Long foodId;

    private Integer amount;

    private BigDecimal price;

}
