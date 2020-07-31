package com.adrew.order.controller.service;

import com.adrew.order.controller.dto.OrderDto;

import java.util.List;

/**
 * Created by Andre on 30.07.2020.
 */
public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    List<OrderDto> getOrderWithLowestPrice();
}

