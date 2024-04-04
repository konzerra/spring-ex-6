package org.konzerra.springex6.domain.category;

import org.konzerra.springex6._generic.domain.Port;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryPort extends Port<Category, Long> {
    Page<Category> findPaginated(Pageable pageable);
}
