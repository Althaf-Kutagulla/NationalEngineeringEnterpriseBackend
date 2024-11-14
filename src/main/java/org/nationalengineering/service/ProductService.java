package org.nationalengineering.service;


import org.nationalengineering.records.ProductRequest;
import org.nationalengineering.records.ProductResponse;

import java.util.List;

public interface ProductService {
    Integer createProduct(ProductRequest productRequest);
    ProductResponse getProductById(Integer productId);
    List<ProductResponse> getAllProducts();
    Boolean updateProduct(ProductRequest productRequest);
    Boolean deleteProduct(Integer productId);
}
