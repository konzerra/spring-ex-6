package org.konzerra.springex6.domain.category.impl;

import org.konzerra.springex6._generic.domain.Mapper;
import org.konzerra.springex6._generic.domain.Port;
import org.konzerra.springex6._generic.domain.abstract_impl.ServiceImpl;
import org.konzerra.springex6.common.pagination.PageRequestDto;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.category.CategoryService;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl
        extends ServiceImpl <Category, Long, CategoryResponseDto, CategorySaveDto, CategoryUpdateDto>
        implements CategoryService {

    protected CategoryServiceImpl(Port port, Mapper mapper) {
        super(port, mapper);

    }

    @Override
    public Page<CategoryResponseDto> findPaginated(PageRequestDto pageRequestDto) {
        return null;
    }
}
