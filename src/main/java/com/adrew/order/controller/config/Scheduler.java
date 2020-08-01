package com.adrew.order.controller.config;

/**
 * Created by Andre on 31.07.2020.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class Scheduler {

    @Scheduled(fixedDelay = 60000)
    @Query(value = "delete from order_controller.orders where order_date_time < (now() - '10 minutes'::interval) ", nativeQuery = true)
    public void scheduleFixedDelayTask() {
        log.info("Scheduler has worked, time - {}", new Date());
    }
}
