package org.konzerra.springex6.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortDto {
    private String property;
    private String direction;
}
