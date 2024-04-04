package org.konzerra.springex6.domain.category.impl;

import org.konzerra.springex6._generic.domain.abstract_impl.ServiceAbsImpl;
import org.konzerra.springex6.common.pagination.PageRequestDto;
import org.konzerra.springex6.common.pagination.PaginationMapper;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.category.CategoryMapper;
import org.konzerra.springex6.domain.category.CategoryPort;
import org.konzerra.springex6.domain.category.CategoryService;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl
        extends ServiceAbsImpl<Category, Long, CategoryResponseDto, CategorySaveDto, CategoryUpdateDto>
        implements CategoryService {

    private final CategoryPort categoryPort;
    private final CategoryMapper categoryMapper;
    protected CategoryServiceImpl(CategoryPort port, CategoryMapper mapper) {
        super(port, mapper);
        this.categoryPort = port;
        this.categoryMapper = mapper;
    }

    @Override
    public Page<CategoryResponseDto> findPaginated(PageRequestDto pageRequestDto) {
        Page<Category> categoryPage = categoryPort.findPaginated(PaginationMapper.toPageable(pageRequestDto));
        return categoryPage.map(categoryMapper::toResponseDto);
    }

}
