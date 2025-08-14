package com.tuxitech.mx.targetforg.mapper.team;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tuxitech.mx.targetforg.dto.request.team.TeamRequest;
import com.tuxitech.mx.targetforg.dto.response.team.TeamResponse;
import com.tuxitech.mx.targetforg.mapper.BaseMapper;
import com.tuxitech.mx.targetforg.mapper.user.UserMapper;
import com.tuxitech.mx.targetforg.model.team.TeamModel;

@Component
public class TeamMapper implements BaseMapper<TeamResponse, TeamRequest, TeamModel>{


    @Autowired
    private UserMapper userMapper;
    //Necesario para crear la entidad a partir de la solicitud o petición
    @Override
    public TeamModel toEntity(TeamRequest dto) {
        return TeamModel.builder()
        .idTeam(dto.getIdTeam())
        .nameTeam(dto.getNameTeam())
        .description(dto.getDescription())
        .sizeTeam(dto.getSizeTeam())
        .lider(userMapper.toEntity(dto.getLider()))
        .build();
    }
    //Necesario para crear la entidad a partir de la respuesta
    public TeamModel toEntity(TeamResponse dto) {
        return TeamModel.builder()
                .idTeam(dto.getIdTeam())
                .nameTeam(dto.getNameTeam())
                .description(dto.getDescription())
                .sizeTeam(dto.getSizeTeam())
                .lider(userMapper.toEntity(dto.getLider()))
                .build();
    }
    
    @Override
    public TeamResponse toDto(TeamModel entity) {
       return TeamResponse.builder()
                .idTeam(entity.getIdTeam())
                .nameTeam(entity.getNameTeam())
                .description(entity.getDescription())
                .sizeTeam(entity.getSizeTeam())
                .lider(userMapper.toDto(entity.getLider()))
                .build();
    }

    @Override
    public List<TeamResponse> toDtos(List<TeamModel> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateEntity(TeamRequest request, TeamModel entity) {
        entity.setNameTeam(request.getNameTeam());
        entity.setDescription(request.getDescription());
        entity.setSizeTeam(request.getSizeTeam());
        entity.setLider(userMapper.toEntity(request.getLider()));
    }
}
