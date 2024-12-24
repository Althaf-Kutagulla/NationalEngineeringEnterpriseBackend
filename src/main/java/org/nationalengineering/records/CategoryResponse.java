package org.nationalengineering.records;

import java.util.List;

public record CategoryResponse(
        Integer categoryId,
        String name,
        List<ProductResponse> productResponses) {
}
