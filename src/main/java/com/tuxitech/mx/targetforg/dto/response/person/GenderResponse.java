package com.tuxitech.mx.targetforg.dto.response.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenderResponse {
    private Long idGender;
    private String gender;
}
