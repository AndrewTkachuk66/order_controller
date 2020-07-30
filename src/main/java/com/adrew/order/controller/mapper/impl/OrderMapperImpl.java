package com.adrew.order.controller.mapper.impl;

import com.adrew.order.controller.domain.OrderEntity;
import com.adrew.order.controller.domain.ProductEntity;
import com.adrew.order.controller.dto.OrderDto;
import com.adrew.order.controller.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Andre on 30.07.2020.
 */
@Component
@AllArgsConstructor
@Slf4j
public class OrderMapperImpl implements OrderMapper{

    @Override
    public OrderEntity toOrderEntity(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(orderDto.getProduct().getId());
        productEntity.setName(orderDto.getProduct().getName());
        orderEntity.setProductEntity(productEntity);
        orderEntity.setId(orderDto.getId());
        orderEntity.setPrice(orderDto.getPrice());
        orderEntity.setQuantity(orderDto.getQuantity());
        orderEntity.setOrderDateTime(orderDto.getOrderDateTime());

        return orderEntity;
    }
}
