package com.tuxitech.mx.targetforg.mapper.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tuxitech.mx.targetforg.dto.request.GenderRequest;
import com.tuxitech.mx.targetforg.dto.response.person.GenderResponse;
import com.tuxitech.mx.targetforg.mapper.BaseMapper;
import com.tuxitech.mx.targetforg.model.person.GenderModel;

@Component
public class GenderMapper implements BaseMapper<GenderResponse, GenderRequest, GenderModel>{

    @Override
    public GenderModel toEntity(GenderRequest dto) {
        return GenderModel.builder()
                .idGender(dto.getIdGender())
                .gender(dto.getGender())
                .build();
    }

    @Override
    public GenderResponse toDto(GenderModel entity) {
        return GenderResponse.builder()
                .idGender(entity.getIdGender())
                .gender(entity.getGender())
                .build();
                
    }

    @Override
    public List<GenderResponse> toDtos(List<GenderModel> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateEntity(GenderRequest request, GenderModel entity) {
        entity.setGender(request.getGender());
    }

}
