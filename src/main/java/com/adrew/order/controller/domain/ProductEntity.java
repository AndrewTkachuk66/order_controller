package com.adrew.order.controller.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Andre on 30.07.2020.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products", schema = "order_controller")
@Data
@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
