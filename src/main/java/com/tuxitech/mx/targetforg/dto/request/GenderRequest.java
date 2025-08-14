package com.tuxitech.mx.targetforg.dto.request;

import jakarta.validation.constraints.*;

import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenderRequest {

    @NotNull(message = MessagesResponse.NOT_NULL_ID_GENDER)
    private Long idGender;

    @NotNull(message = MessagesResponse.NOT_NULL_GENDER)
    @NotBlank(message = MessagesResponse.NOT_BLANK_GENDER)
    private String gender;
}
