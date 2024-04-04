package org.konzerra.springex6.domain.category;

import org.konzerra.springex6._generic.domain.Mapper;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;

public interface CategoryMapper
        extends Mapper<Category, CategoryResponseDto, CategorySaveDto, CategoryUpdateDto> {
}
