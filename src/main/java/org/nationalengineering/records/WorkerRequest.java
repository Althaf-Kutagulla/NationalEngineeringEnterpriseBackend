package org.nationalengineering.records;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.nationalengineering.constants.WorkingStatus;

public record WorkerRequest(
        Integer id,
        @NotBlank(message = "FirstName should not be blank")
        @NotEmpty(message = "FirstName should not be empty")
        String firstName,
        @NotBlank(message = "LastName should not be blank")
        @NotEmpty(message = "LastName should not be empty")
        String lastName,
        @NotBlank(message = "phoneNumber should not be blank")
        @NotEmpty(message = "phoneNumber should not be empty")
        String phoneNumber,
        @Nullable
        String alterPhoneNumber,
        @Nullable
        String town,
        @Nullable
        String village,
        @Nullable
        String address,
        WorkingStatus workingStatus
) {
}
