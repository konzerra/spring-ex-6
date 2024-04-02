package org.konzerra.springex6.domain.category;

import org.konzerra.springex6._generic.domain.Service;
import org.konzerra.springex6.common.pagination.PageRequestDto;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CategoryService
        extends Service<Category, Long, CategoryResponseDto, CategorySaveDto, CategoryUpdateDto>
{

    Page<CategoryResponseDto> findPaginated(PageRequestDto pageRequestDto);
}
