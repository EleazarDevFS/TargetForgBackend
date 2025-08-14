package com.tuxitech.mx.targetforg.mapper.user;

import com.tuxitech.mx.targetforg.dto.request.UserRequest;
import com.tuxitech.mx.targetforg.dto.response.user.UserResponse;
import com.tuxitech.mx.targetforg.model.user.UserModel;
import com.tuxitech.mx.targetforg.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<UserResponse, UserRequest, UserModel>{

    @Override
    public UserModel toEntity(UserRequest dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public UserResponse toDto(UserModel entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<UserResponse> toDtos(List<UserModel> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDtos'");
    }

    @Override
    public void updateEntity(UserRequest request, UserModel entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }

}
