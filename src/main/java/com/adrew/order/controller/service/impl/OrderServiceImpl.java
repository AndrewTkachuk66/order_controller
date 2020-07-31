package com.adrew.order.controller.service.impl;

import com.adrew.order.controller.domain.OrderEntity;
import com.adrew.order.controller.dto.OrderDto;
import com.adrew.order.controller.mapper.OrderMapper;
import com.adrew.order.controller.repository.OrderRepository;
import com.adrew.order.controller.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andre on 30.07.2020.
 */
@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        OrderEntity orderEntity = orderMapper.toOrderEntity(orderDto);
        orderRepository.save(orderEntity);
        log.info("Order was created: {}", orderDto);
        return orderDto;
    }

    @Override
    public List<OrderDto> getOrderWithLowestPrice() {
        List<OrderEntity> ordersWithLowestPrice = orderRepository.getOrderWithLowestPrice();
        log.info("Order with the lowest price was retrieved: {}", ordersWithLowestPrice);

        return orderMapper.toOrderDtoList(ordersWithLowestPrice);
    }
}
