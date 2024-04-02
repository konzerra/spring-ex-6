package org.konzerra.springex6.domain.category.impl;

import org.konzerra.springex6._generic.domain.Mapper;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;
import org.springframework.stereotype.Service;


@Service
public class CategoryMapperImpl
        implements Mapper<Category, CategoryResponseDto, CategorySaveDto, CategoryUpdateDto> {

    @Override
    public Category fromSaveDto(CategorySaveDto saveDto) {
        return null;
    }

    @Override
    public Category fromUpdateDto(CategoryUpdateDto updateDto) {
        return null;
    }

    @Override
    public CategoryResponseDto toResponseDto(Category category) {
        return null;
    }

}
