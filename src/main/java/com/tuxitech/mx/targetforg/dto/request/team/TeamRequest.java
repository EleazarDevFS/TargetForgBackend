package com.tuxitech.mx.targetforg.dto.request.team;

import com.tuxitech.mx.targetforg.dto.request.user.UserRequest;
import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequest {
    @NotNull(message = MessagesResponse.NOT_NULL_TEAM_ID)
    private Long idTeam;

    @NotBlank(message = MessagesResponse.NOT_BLANK_NAME_TEAM)
    private String nameTeam; 

    @NotBlank(message = MessagesResponse.NOT_BLANK_DESCRIPTION_TEAM)
    private String description;

    @Size(min = 7, max = 12, message = MessagesResponse.INVALID_SIZE_TEAM)
    private int sizeTeam;

    @Valid
    @NotNull(message = MessagesResponse.NOT_BLANK_LIDER)
    private UserRequest lider;
}
