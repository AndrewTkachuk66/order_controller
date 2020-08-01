package com.adrew.order.controller.config;

/**
 * Created by Andre on 31.07.2020.
 */

import com.adrew.order.controller.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@AllArgsConstructor
public class Scheduler {

    private OrderRepository orderRepository;

    @Scheduled(fixedDelay = 60000)
    public void scheduleFixedDelayTask() {
        orderRepository.deleteAllOrdersOlderTenMinutes();
        log.info("Scheduler has worked, old orders were deleted time - {}", new Date());
    }
}
