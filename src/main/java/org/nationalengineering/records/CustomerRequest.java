package org.nationalengineering.records;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CustomerRequest(
        Integer id,
        @NotEmpty(message = "firstName should not be empty")
        @NotBlank(message = "firstName should not be blank")
        String firstName,
        @NotEmpty(message = "lastName should not be empty")
        @NotBlank(message = "lastName should not be empty")
        String lastName,
        @NotEmpty(message = "phoneNumber should not be empty")
        @NotBlank(message = "phoneNumber should not be empty")
        String phoneNumber,
        @Nullable
        String state,
        @Nullable
        String town,
        @Nullable
        String village
) {
}
