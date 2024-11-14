package org.nationalengineering.records;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        Integer categoryId,
        Integer quantity,
        BigDecimal price
) {
}
