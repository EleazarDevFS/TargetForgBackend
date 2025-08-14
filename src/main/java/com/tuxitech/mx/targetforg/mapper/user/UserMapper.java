package com.tuxitech.mx.targetforg.mapper.user;

import com.tuxitech.mx.targetforg.dto.request.user.UserRequest;
import com.tuxitech.mx.targetforg.dto.response.user.UserResponse;
import com.tuxitech.mx.targetforg.model.user.UserModel;
import com.tuxitech.mx.targetforg.mapper.BaseMapper;
import com.tuxitech.mx.targetforg.mapper.person.PersonMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<UserResponse, UserRequest, UserModel>{

    @Autowired
    private PersonMapper personMapper;

    @Override
    public UserModel toEntity(UserRequest dto) {
       return UserModel.builder()
                .id(dto.getId())
                .person(personMapper.toEntity(dto.getPerson()))
                .build();
    }

    @Override
    public UserResponse toDto(UserModel entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .person(personMapper.toDto(entity.getPerson()))
                .build();
    }

    @Override
    public List<UserResponse> toDtos(List<UserModel> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public void updateEntity(UserRequest request, UserModel entity) {
        entity.setId(request.getId());
        personMapper.updateEntity(request.getPerson(), entity.getPerson());
    }

}
