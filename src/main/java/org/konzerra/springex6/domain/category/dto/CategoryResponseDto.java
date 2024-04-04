package org.konzerra.springex6.domain.category.dto;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryResponseDto {
    Long id;
    String name;
    String description;
}
