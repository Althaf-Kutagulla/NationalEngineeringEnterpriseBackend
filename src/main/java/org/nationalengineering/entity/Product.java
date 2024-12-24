package org.nationalengineering.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(targetEntity = Category.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;
    private Integer quantity;
    private BigDecimal price;
}
