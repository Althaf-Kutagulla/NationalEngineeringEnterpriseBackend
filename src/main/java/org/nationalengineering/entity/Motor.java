package org.nationalengineering.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "motors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String model;
}
