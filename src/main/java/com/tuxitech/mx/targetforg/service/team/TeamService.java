package com.tuxitech.mx.targetforg.service.team;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tuxitech.mx.targetforg.dto.request.team.TeamRequest;
import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;
import com.tuxitech.mx.targetforg.dto.response.team.TeamResponse;
import com.tuxitech.mx.targetforg.mapper.team.TeamMapper;
import com.tuxitech.mx.targetforg.model.team.TeamModel;
import com.tuxitech.mx.targetforg.repository.team.ITeamRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;

@Service
public class TeamService {

    private ITeamRepository teamRepository;
    private TeamMapper teamMapper;

    public TeamResponse createTeam(@NonNull TeamRequest teamRequest) throws Exception{
        try{
            Assert.notNull(teamRequest, MessagesResponse.TEAM_NOT_NULL);
            if(teamRepository.existsById(teamRequest.getIdTeam())){
                throw new Exception(MessagesResponse.TEAM_ALREADY_EXIST);
            }

            TeamModel teamModel = teamMapper.toEntity(teamRequest);
            //Guardamos el equipo
            TeamModel teamSaved = teamRepository.save(teamModel);
            return teamMapper.toDto(teamSaved);
        }catch(Exception e){
            throw e;
        }
    }

    @Transactional 
    public TeamModel createTeamEntity(TeamRequest teamRequest){
        Assert.notNull(teamRequest, MessagesResponse.TEAM_NOT_NULL);
        TeamResponse existingTeam = this.getTeamById(teamRequest.getIdTeam());
        if(existingTeam != null){
            return teamMapper.toEntity(existingTeam);
        }

        TeamModel teamModel = teamMapper.toEntity(existingTeam);
        return teamRepository.save(teamModel);
    }

    @Transactional
    public TeamResponse getTeamById(@NonNull Long idTeam){
        try {
            return teamRepository.findById(idTeam)
            .map(teamMapper::toDto)
            .orElse(null);  
        } catch (Exception e) {
            throw e;// Aquí retornaríamos una excepción personalizada
        }
    }

    @Transactional
    public List<TeamResponse> getAllTeams(){
        try {
            List<TeamModel> allTeams = teamRepository.findAll();
            return allTeams.stream()
            .map(teamMapper::toDto)
            .collect(Collectors.toList());
        } catch (Exception e) {
            throw e;// Aquí retornaríamos una excepción personalizada
        }
    }

    @Transactional
    public TeamResponse updateTeam(@NonNull Long idTeam, TeamRequest updateTeamRequest) throws Exception{
        try {
            Assert.notNull(updateTeamRequest, MessagesResponse.TEAM_NOT_NULL);
            return teamMapper.toDto(updatedTeam(idTeam, updateTeamRequest));
        } catch (Exception e) {
            throw e;// Aquí retornaríamos una excepción personalizada
        }
    }
    @Transactional
    public TeamModel updatedTeam(Long idTeam, TeamRequest request) throws Exception{
        TeamModel teamModel = teamRepository.findById(idTeam)
        .orElseThrow(()-> new Exception());
        teamMapper.updateEntity(request, teamModel);
        return teamRepository.save(teamModel);
    }
}
