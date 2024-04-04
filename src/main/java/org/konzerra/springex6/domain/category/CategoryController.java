package org.konzerra.springex6.domain.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.konzerra.springex6.common.pagination.PageRequestDto;
import org.konzerra.springex6.domain.category.dto.CategoryResponseDto;
import org.konzerra.springex6.domain.category.dto.CategorySaveDto;
import org.konzerra.springex6.domain.category.dto.CategoryUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping(CategoryApi.FIND_BY_ID)
    ResponseEntity<CategoryResponseDto> findById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping(CategoryApi.PAGINATED)
    ResponseEntity<Page<CategoryResponseDto>> findPaginated(
            @RequestParam("pageRequestDto") String pageRequestDtoEncoded
    ) throws Exception {
        var pageRequestJson = URLDecoder.decode(pageRequestDtoEncoded, "UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PageRequestDto pageRequestDto = objectMapper.readValue(pageRequestJson, PageRequestDto.class);
            return ResponseEntity.ok(categoryService.findPaginated(pageRequestDto));
        } catch (IOException e) {
            //TODO handle exception
            throw new Exception();
        }

    }

    @PostMapping(CategoryApi.SAVE)
    ResponseEntity<CategoryResponseDto> save(
            @RequestBody @Valid CategorySaveDto saveDto
    ){
        return ResponseEntity.ok(categoryService.save(saveDto));
    }

    @PutMapping(CategoryApi.UPDATE)
    ResponseEntity<CategoryResponseDto> update(
            @RequestBody @Valid CategoryUpdateDto updateDto
    ){
        return ResponseEntity.ok(categoryService.update(updateDto));
    }

    @DeleteMapping(CategoryApi.DELETE_BY_ID)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
