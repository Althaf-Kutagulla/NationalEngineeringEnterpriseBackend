package org.nationalengineering.records;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.nationalengineering.constants.MotorTicketStatus;


public record MotorTicketRequest(
        Integer id,
        Integer customerId,
        Integer motorId,
        String description,
        @Enumerated(EnumType.STRING)
        MotorTicketStatus motorTicketStatus
) {
}
