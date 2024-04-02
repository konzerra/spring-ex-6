package org.konzerra.springex6.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDto {
    private int page;
    private int size;
    private List<SortDto> sort;
}
