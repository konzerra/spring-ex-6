package org.konzerra.springex6._generic.domain;

public interface Mapper <Entity, ResponseDto, SaveDto, UpdateDto>{

    Entity fromSaveDto(SaveDto saveDto);

    Entity fromUpdateDto(UpdateDto updateDto);

    ResponseDto toResponseDto(Entity entity);
}
