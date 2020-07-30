package com.adrew.order.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Andre on 30.07.2020.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Double price;
    private int quantity;
    private ProductDto product;
    private Date OrderDateTime;
}
