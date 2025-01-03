package org.nationalengineering.service;

import org.nationalengineering.records.ProductUsageRequest;
import org.nationalengineering.records.ProductUsageResponse;

import java.util.List;

public interface ProductUsageService {
    ProductUsageResponse getProductUsage(Integer id);

    List<ProductUsageResponse> getAllProductUsages();

    Boolean createProductUsage(ProductUsageRequest productUsageRequest);

    Boolean updateProductUsage(ProductUsageRequest productUsageRequest);

    Boolean delete(Integer id);
}
