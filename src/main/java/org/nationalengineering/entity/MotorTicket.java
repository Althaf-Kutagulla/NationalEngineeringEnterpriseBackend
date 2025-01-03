package org.nationalengineering.entity;

import jakarta.persistence.*;
import lombok.*;
import org.nationalengineering.constants.MotorTicketStatus;
import java.util.List;


@Entity
@Table(name = "motor_tickets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MotorTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Motor motor;
    @OneToMany(mappedBy = "motorTicket" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductUsage> productUsageList;
    private String description;
    private MotorTicketStatus motorTicketStatus;
}
