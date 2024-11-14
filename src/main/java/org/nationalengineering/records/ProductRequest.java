package org.nationalengineering.records;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name should not be null.")
        String name,
        @NotNull(message = "Category_id should not be null")
        Integer categoryId,
        @NotNull(message = "Quantity should not be null")
        @Size(min = 1,message = "quantity should be minimum 1")
        Integer quantity,
        @NotNull(message = "Price should not be null")
        @Size(min = 1)
        BigDecimal price
) {
}
