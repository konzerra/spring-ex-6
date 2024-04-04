package org.konzerra.springex6.domain.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDto {

    @NotNull(message = "Id must not be NULL")
    private Long id;
    @NotBlank(message = "Blank name not allowed")
    private String name;
    @NotBlank(message = "Blank description not allowed")
    private String description;

}
