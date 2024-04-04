package org.konzerra.springex6._generic.domain.abstract_impl;


import org.konzerra.springex6._generic.domain.Mapper;
import org.konzerra.springex6._generic.domain.Port;
import org.konzerra.springex6._generic.domain.Service;

public abstract class ServiceAbsImpl<Entity, Id, ResponseDto, SaveDto, UpdateDto>
        implements Service<Entity, Id, ResponseDto, SaveDto, UpdateDto> {

    private final Port<Entity, Id> port;
    private final Mapper<Entity,ResponseDto, SaveDto, UpdateDto> mapper;
    protected ServiceAbsImpl(Port<Entity, Id> port, Mapper<Entity, ResponseDto, SaveDto, UpdateDto> mapper) {
        this.port = port;
        this.mapper = mapper;
    }

    @Override
    public ResponseDto findById(Id id) {
        return mapper.toResponseDto(port.findById(id));
    }

    @Override
    public ResponseDto save(SaveDto saveDto) {
        return mapper.toResponseDto(
                port.save(mapper.fromSaveDto(saveDto))
        );
    }

    @Override
    public ResponseDto update(UpdateDto updateDto) {
        return mapper.toResponseDto(
                port.update(mapper.fromUpdateDto(updateDto))
        );
    }

    @Override
    public void deleteById(Id id) {
        port.deleteById(id);
    }
}
