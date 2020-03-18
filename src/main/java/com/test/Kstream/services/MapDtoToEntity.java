package com.test.Kstream.services;

public interface MapDtoToEntity<T, E> {
    T MapToEntity(E Dto, Class<T> Entity);

    void SetEntityFields(E Dto, T Entity);
}
