package org.nationalengineering.records;

public record CustomerResponse(
        Integer id,
        String firstName,
        String lastName,
        String phoneNumber,
        String state,
        String town,
        String village
) {
}
