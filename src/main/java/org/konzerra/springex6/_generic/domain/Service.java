package org.konzerra.springex6._generic.domain;

public interface Service <Entity, Id, ResponseDto, SaveDto, UpdateDto>{

    ResponseDto findById(Id id);

    ResponseDto save(SaveDto saveDto);

    ResponseDto update(UpdateDto updateDto);

    void deleteById(Id id);


}
