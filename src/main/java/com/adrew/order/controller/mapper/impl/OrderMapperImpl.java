package com.adrew.order.controller.mapper.impl;

import com.adrew.order.controller.domain.OrderEntity;
import com.adrew.order.controller.domain.ProductEntity;
import com.adrew.order.controller.dto.OrderDto;
import com.adrew.order.controller.dto.ProductDto;
import com.adrew.order.controller.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OrderDto> toOrderDtoList(List<OrderEntity> orderEntityList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for(OrderEntity orderEntity: orderEntityList){
            OrderDto orderDto = new OrderDto();
            ProductDto productDto = new ProductDto();
            productDto.setId(orderEntity.getProductEntity().getId());
            productDto.setName(orderEntity.getProductEntity().getName());
            orderDto.setProduct(productDto);
            orderDto.setId(orderEntity.getId());
            orderDto.setOrderDateTime(orderEntity.getOrderDateTime());
            orderDto.setPrice(orderEntity.getPrice());
            orderDto.setQuantity(orderEntity.getQuantity());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
}
