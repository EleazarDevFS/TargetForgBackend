package com.tuxitech.mx.targetforg.dto.response.team;

import com.tuxitech.mx.targetforg.dto.response.user.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponse {

    private Long idTeam;
    private String nameTeam, description;
    private int sizeTeam;
    private UserResponse lider;

}
