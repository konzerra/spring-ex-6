package org.konzerra.springex6.domain.category.impl;

import org.konzerra.springex6._generic.domain.abstract_impl.PortAbsImpl;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.category.CategoryPort;
import org.konzerra.springex6.domain.category.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryPortImpl extends PortAbsImpl<Category, Long> implements CategoryPort  {

    private final CategoryRepository categoryRepository;
    protected CategoryPortImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> findPaginated(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
