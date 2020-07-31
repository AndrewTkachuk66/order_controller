package com.adrew.order.controller.config;

/**
 * Created by Andre on 31.07.2020.
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedDelay = 60000)
    @Query(value = "DELETE FROM order_controller.orders WHERE order_date_time < (UNIX_TIMESTAMP() - 600);", nativeQuery = true)
    public void scheduleFixedDelayTask() {
    }
}
