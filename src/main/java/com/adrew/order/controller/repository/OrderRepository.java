package com.adrew.order.controller.repository;

import com.adrew.order.controller.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andre on 30.07.2020.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>, JpaSpecificationExecutor<OrderEntity> {
    @Query(value = "SELECT *\n" +
            "FROM order_controller.orders\n" +
            "WHERE price = (SELECT MIN(price)\n" +
            "             FROM order_controller.orders );",  nativeQuery = true)
    List<OrderEntity> getOrderWithLowestPrice();


    @Transactional
    @Modifying
    @Query(value = "delete from order_controller.orders where order_date_time < (now() - interval '10 minutes');", nativeQuery = true)
    void deleteAllOrdersOlderTenMinutes();
}
