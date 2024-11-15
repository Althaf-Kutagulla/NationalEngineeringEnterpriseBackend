package org.nationalengineering.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Product> productList;
}
