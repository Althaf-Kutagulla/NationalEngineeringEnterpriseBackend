package org.nationalengineering.mappers;

import org.nationalengineering.entity.MotorTicket;
import org.nationalengineering.records.MotorTicketRequest;
import org.springframework.stereotype.Component;

@Component
public class MotorTicketMapper {
    public MotorTicket toMotorTicket(MotorTicketRequest motorTicketRequest) {
        return MotorTicket.builder()
                .id(motorTicketRequest.id())
                .description(motorTicketRequest.description())
                .motorTicketStatus(motorTicketRequest.motorTicketStatus())
                .build();

    }
}
