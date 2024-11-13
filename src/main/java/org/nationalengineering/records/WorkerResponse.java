package org.nationalengineering.records;

import org.nationalengineering.constants.WorkingStatus;

import java.time.LocalDateTime;

public record WorkerResponse(
        String firstName,
        String lastName,
        String phoneNumber,
        String alterPhoneNumber,
        String town,
        String village,
        String address,
        WorkingStatus workingStatus,
        LocalDateTime joinedDate,
        LocalDateTime leftDate
) {
}
