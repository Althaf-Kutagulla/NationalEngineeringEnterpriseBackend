package org.nationalengineering.records;

public record ProductUsageResponse(
        Integer id,
        Integer motorTicketId,
        ProductResponse productId,
        Integer quantityUsed
) {
}
