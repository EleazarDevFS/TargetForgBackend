package com.tuxitech.mx.targetforg.dto.request.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.tuxitech.mx.targetforg.dto.request.person.PersonRequest;
import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id; 

    @Valid
    @NotNull(message = MessagesResponse.NOT_NULL_PERSON)
    PersonRequest person;
}
