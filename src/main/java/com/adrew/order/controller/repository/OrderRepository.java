package com.adrew.order.controller.repository;

import com.adrew.order.controller.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Andre on 30.07.2020.
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long>, JpaSpecificationExecutor<OrderEntity> {
    @Query(value = "SELECT *\n" +
            "FROM order_controller.orders\n" +
            "WHERE price = (SELECT MIN(price)\n" +
            "             FROM order_controller.orders );",  nativeQuery = true)
    List<OrderEntity> getOrderWithLowestPrice();
}
