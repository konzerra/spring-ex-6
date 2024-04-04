package org.konzerra.springex6.domain.category.impl;

import org.konzerra.springex6._generic.domain.Mapper;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.category.CategoryMapper;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;
import org.springframework.stereotype.Service;


@Service
public class CategoryMapperImpl
        implements CategoryMapper {

    @Override
    public Category fromSaveDto(CategorySaveDto saveDto) {
        return Category.builder()
                .description(saveDto.getDescription())
                .name(saveDto.getName())
                .build();
    }

    @Override
    public Category fromUpdateDto(CategoryUpdateDto updateDto) {
        return Category.builder()
                .id(updateDto.getId())
                .description(updateDto.getDescription())
                .name(updateDto.getName())
                .build();
    }

    @Override
    public CategoryResponseDto toResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

}
