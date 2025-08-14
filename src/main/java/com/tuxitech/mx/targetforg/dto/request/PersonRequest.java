package com.tuxitech.mx.targetforg.dto.request;

import java.time.LocalDate;

import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {

    @NotBlank(message = MessagesResponse.NOT_BLANK_CURP)
    @Size(min = 18, max = 18, message = MessagesResponse.SIZE_CURP)
    private String curp; 

    @NotBlank(message = MessagesResponse.NOT_BLANK_FIRST_NAME)
    @Size(max = 60, message = MessagesResponse.SIZE_FIRST_NAME)
    private String firstName;

    @Size(max = 60, message = MessagesResponse.SIZE_FIRST_NAME)
    private String secondName;

    @NotBlank(message = MessagesResponse.NOT_BLANK_FIRST_NAME)
    @Size(max = 60, message = MessagesResponse.SIZE_FIRST_NAME)
    private String firstLastName;

    @Size(max = 60, message = MessagesResponse.SIZE_SECOND_LAST_NAME)
    private String secondLastName;
    
    @NotBlank(message = MessagesResponse.NOT_BLANK_EMAIL)
    @Size(max = 200, message = MessagesResponse.SIZE_EMAIL)
    @Email(message = MessagesResponse.VALID_EMAIL)
    private String  mail;

    @NotNull(message = MessagesResponse.NOT_NULL_BIRTH_DATE)
    private LocalDate birthDate;

    @Pattern(regexp = "^\\d{10}$", message = MessagesResponse.PATTERN_PHONE)
    private String phone;

    @Valid
    @NotNull(message = MessagesResponse.NOT_NULL_GENDER)
    private GenderRequest gender;
}
