package com.adrew.order.controller.controller;

import com.adrew.order.controller.dto.OrderDto;
import com.adrew.order.controller.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Andre on 30.07.2020.
 */
@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {
    private OrderService orderService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created order"),
            @ApiResponse(code = 400, message = "Invalid data"),
    })
    @ApiOperation(value = "Save order into database",
            response = OrderDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @ApiOperation(value = "get order with the lowest price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "get order successfully"),
            @ApiResponse(code = 404, message = "order is not found")

    })
    @GetMapping("lowest/price")
    public List<OrderDto> getOrdersWithLowestPrice(){
        return orderService.getOrderWithLowestPrice();
    }
}
