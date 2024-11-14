package org.nationalengineering.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Product> productList;
}
