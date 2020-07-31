package com.adrew.order.controller.mapper;

import com.adrew.order.controller.domain.OrderEntity;
import com.adrew.order.controller.dto.OrderDto;

import java.util.List;

/**
 * Created by Andre on 30.07.2020.
 */
public interface OrderMapper {
    OrderEntity toOrderEntity(OrderDto orderDto);

    List<OrderDto> toOrderDtoList(List<OrderEntity> orderEntity);
}


