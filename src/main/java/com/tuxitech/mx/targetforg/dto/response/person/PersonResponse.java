package com.tuxitech.mx.targetforg.dto.response.person;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private String curp; 
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String  mail;
    private LocalDate birthDate;
    private GenderResponse gender;
    private String phone;

     public String getFullName() {
        return firstName + " " +
                ((secondName != null && !secondName.trim().isEmpty()) ? secondName + " " : "") +
                firstLastName + " " +
                secondLastName;
    }

}
