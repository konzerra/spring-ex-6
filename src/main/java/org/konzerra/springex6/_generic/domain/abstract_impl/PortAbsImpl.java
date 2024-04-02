package org.konzerra.springex6._generic.domain.abstract_impl;


import org.konzerra.springex6._generic.domain.Port;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class PortAbsImpl <Entity, Id> implements Port<Entity, Id> {

    private final JpaRepository<Entity, Id> repository;


    protected PortAbsImpl(JpaRepository<Entity, Id> repository) {
        this.repository = repository;
    }

    @Override
    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    @Override
    public Entity findById(Id id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public boolean deleteById(Id id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Entity update(Entity entity) {
        return repository.save(entity);
    }
}
