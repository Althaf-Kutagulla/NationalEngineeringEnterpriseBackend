package org.nationalengineering.records;

import org.nationalengineering.constants.MotorTicketStatus;


import java.util.List;

public record MotorTicketResponse(
        Integer id,
        CustomerResponse customer,
        MotorResponse motor,
        List<ProductUsageResponse> productUsageList,
        String description,
        MotorTicketStatus motorTicketStatus
) {
}
