package org.konzerra.springex6.common.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationMapper {

    public static Pageable toPageable(PageRequestDto pageRequestDto) {
        Sort sort = Sort.by(pageRequestDto.getSort().stream()
                .map(sortDto -> new Sort.Order(Sort.Direction.fromString(sortDto.getDirection()), sortDto.getProperty()))
                .toArray(Sort.Order[]::new));

        return PageRequest.of(pageRequestDto.getPage(), pageRequestDto.getSize(), sort);
    }
}
