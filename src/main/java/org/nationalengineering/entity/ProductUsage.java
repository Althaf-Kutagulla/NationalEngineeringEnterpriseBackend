package org.nationalengineering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Table(name = "products_usages")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "motor_ticket_id")
    @NotNull
    private MotorTicket motorTicket;
    @ManyToOne
    @NotNull
    private Product product;
    private Integer quantityUsed;
}
