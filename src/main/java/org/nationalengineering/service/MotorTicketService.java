package org.nationalengineering.service;

import org.nationalengineering.records.MotorTicketRequest;
import org.nationalengineering.records.MotorTicketResponse;

import java.util.List;

public interface MotorTicketService {
    Integer createMotorTicket(MotorTicketRequest motorTicketRequest);

    Boolean updateMotorTicket(MotorTicketRequest motorTicketRequest);

    Boolean deleteMotorTicket(Integer motorTicketId);

    MotorTicketResponse getMotorTicketById(Integer motorTicketId);

    List<MotorTicketResponse> getAllMotorTickets();
}
