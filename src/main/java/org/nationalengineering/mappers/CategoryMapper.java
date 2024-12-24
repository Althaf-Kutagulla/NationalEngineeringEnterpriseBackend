package org.nationalengineering.mappers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.Category;
import org.nationalengineering.records.CategoryRequest;
import org.nationalengineering.records.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryMapper {

    private final ProductMapper productMapper;

    public Category toCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .categoryId(categoryRequest.categoryId())
                .name(categoryRequest.name())
                .build();
    }
    public CategoryResponse toCategoryReponse(Category category) {
        return new CategoryResponse(category.getCategoryId(), category.getName(),productMapper.toProductResponseList(category.getProductList()));
    }
}
