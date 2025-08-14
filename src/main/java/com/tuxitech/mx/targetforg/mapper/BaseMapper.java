package com.tuxitech.mx.targetforg.mapper;

import java.util.List;

public interface BaseMapper<D, R, E> { //d: DTO RESPONSE, R: DTO REQUEST, E: ENTITY 
    E toEntity(R dto);
    D toDto(E entity);
    List<D> toDtos(List<E> entities);
    void updateEntity(R request, E entity);
}
