package com.test.Kstream.services;

public interface MapDtoToEntity<T, E, F> {
    T MapToEntity(F Dto, Class<T> Entity);

    void SetEntityFields(E Dto, T Entity) throws Exception;

}
