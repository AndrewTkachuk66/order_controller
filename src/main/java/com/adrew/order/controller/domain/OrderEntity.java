package com.adrew.order.controller.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Andre on 30.07.2020.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "order_controller")
@Data
@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity productEntity;

    @Column(name = "order_date_time", nullable = false)
    private Date OrderDateTime;
}
