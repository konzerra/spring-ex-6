package org.konzerra.springex6.domain.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDto {
    @NotBlank(message = "Blank name not allowed")
    private String name;
    @NotBlank(message = "Blank description not allowed")
    private String description;

}
