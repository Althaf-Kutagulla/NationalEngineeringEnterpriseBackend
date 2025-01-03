package org.nationalengineering.mappers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.ProductUsage;
import org.nationalengineering.records.ProductUsageRequest;
import org.nationalengineering.records.ProductUsageResponse;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductUsageMapper {
    private final ProductMapper productMapper;
    public ProductUsageResponse toProductUsageResponse(ProductUsage productUsage) {
        return new ProductUsageResponse(
                productUsage.getId(),
                productUsage.getMotorTicket().getId(),
                productMapper.toProductResponse(productUsage.getProduct()),
                productUsage.getQuantityUsed()
        );
    }

    public ProductUsage toProductUsage(ProductUsageRequest productUsageRequest) {
        return ProductUsage.builder()
                .id(productUsageRequest.id())
                .quantityUsed(productUsageRequest.quantityUsed())
                .build();
    }
}
