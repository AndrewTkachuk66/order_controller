package com.adrew.order.controller.service;

import com.adrew.order.controller.dto.OrderDto;

/**
 * Created by Andre on 30.07.2020.
 */
public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderWithLowestPrice();
}

