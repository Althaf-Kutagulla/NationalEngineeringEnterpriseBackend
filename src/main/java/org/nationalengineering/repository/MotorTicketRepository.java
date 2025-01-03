package org.nationalengineering.repository;

import org.nationalengineering.entity.MotorTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorTicketRepository extends JpaRepository<MotorTicket, Integer> {
}
