package com.tuxitech.mx.targetforg.controller.team;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tuxitech.mx.targetforg.dto.request.team.TeamRequest;
import com.tuxitech.mx.targetforg.dto.response.team.TeamResponse;
import com.tuxitech.mx.targetforg.service.team.TeamService;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TeamResponse> createTeam(@Valid @RequestBody TeamRequest request) throws Exception{ //Se tendria que personalizar una excepción para no escribir esto (throws Exception)
        return ResponseEntity.ok(teamService.createTeam(request));
    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams(){
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PutMapping("/{idTeam}")
    public ResponseEntity<TeamResponse> updateTeam(@Valid @PathVariable Long idTeam,
                                                    @Valid @RequestBody TeamRequest request) throws Exception{
        return ResponseEntity.ok(teamService.updateTeam(request.getIdTeam(), request));
    }

    @DeleteMapping("/{idTeam}")
    public ResponseEntity<TeamResponse> deleteTeamById(@NonNull Long idTeam) throws Exception{
        teamService.deleteTeamById(idTeam);
        return ResponseEntity.noContent().build();
    }
}
