package org.nationalengineering.entity;

import jakarta.persistence.*;
import lombok.*;
import org.nationalengineering.constants.WorkingStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String alterPhoneNumber;
    private String town;
    private String village;
    private String address;
    @CreatedDate
    private LocalDateTime joinedDate;
    private LocalDateTime leftDate;
    @Enumerated(EnumType.STRING)
    private WorkingStatus workingStatus;
}
