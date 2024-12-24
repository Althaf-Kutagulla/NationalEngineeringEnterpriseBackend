package org.nationalengineering.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String state;
    private String town;
    private String village;
}
