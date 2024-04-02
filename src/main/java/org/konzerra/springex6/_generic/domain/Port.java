package org.konzerra.springex6._generic.domain;

public interface Port <Entity, Id> {

    Entity save(Entity entity);

    Entity findById(Id id);

    boolean deleteById(Id id);

    Entity update(Entity entity);

}
