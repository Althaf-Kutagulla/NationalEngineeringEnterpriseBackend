package org.nationalengineering.records;
import jakarta.validation.constraints.Min;

public record ProductUsageRequest(
        Integer id,
        Integer motorTicketId,
        Integer productId,
        @Min(value = 0,message = "quantityUsed cannot be negative")
        Integer quantityUsed
) {
}
