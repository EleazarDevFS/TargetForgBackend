package com.tuxitech.mx.targetforg.dto.response.user;

import com.tuxitech.mx.targetforg.dto.response.person.PersonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private PersonResponse person;

}
