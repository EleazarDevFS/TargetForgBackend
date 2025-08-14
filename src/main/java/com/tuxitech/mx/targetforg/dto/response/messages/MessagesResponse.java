package com.tuxitech.mx.targetforg.dto.response.messages;

public class MessagesResponse {

    //PERSON VALIDATION REQUEST
    public static final String NOT_BLANK_CURP = "El curp no puede estar en blanco";
    public static final String SIZE_CURP = "El curp debe tener exactamente 18 caracteres";
    public static final String NOT_BLANK_FIRST_NAME = "El nombre no puede estar en blanco";
    public static final String SIZE_FIRST_NAME = "El primer nombre debe tener como máximo 60 caracteres";
    public static final String SIZE_SECOND_NAME = "El segundo nombre debe tener como máximo 60 caracteres";
    public static final String NOT_BLANK_FIRST_LAST_NAME = "El primer apellido no puede estar en blanco";
    public static final String SIZE_FIRST_LAST_NAME = "El primer apellido debe tener como máximo 70 caracteres";
    public static final String SIZE_SECOND_LAST_NAME = "El segundo apellido debe tener como máximo 70 caracteres";
    public static final String VALID_EMAIL = "El email debe ser válido";
    public static final String SIZE_EMAIL = "El email debe tener como máximo 200 caracteres";
    public static final String NOT_BLANK_EMAIL = "El email no puede estar en blanco";
    public static final String NOT_NULL_BIRTH_DATE = "La fecha de nacimiento no puede ser nula";
    public static final String PATTERN_PHONE = "El número de teléfono debe tener 10 digitos";

    public static final String PERSON_ALREADY_EXISTS = "La persona ya existe";
    public static final String UPDATE_PERSON_REQUEST_NULL = "updateRequestPerson no puede ser nulo";

    public static final String TEAM_NOT_NULL = "El equipo no puede ser nulo";
    public static final String TEAM_ALREADY_EXIST = "El equipo ya existe";
    //GENDER VALIDATION REQUEST
    public static final String NOT_NULL_ID_GENDER = "El ID del género no puede ser nulo";
    public static final String NOT_BLANK_GENDER = "El género no puede estar en blanco";
    public static final String NOT_NULL_GENDER = "El género no puede ser nulo";

    //USER VALIDATION REQUEST
    public static final String NOT_NULL_USER_ID = "El ID del usuario no debe ser nulo";
    public static final String NOT_NULL_PERSON = "La persona no debe ser nula";
    public static final String NOT_NULL_USER = "El usuario no debe ser nulo";
    public static final String USER_ALREADY_EXISTS = "El usuario ya existe";

    //TEAM VALIDATION REQUEST
    public static final String NOT_NULL_TEAM_ID = "El ID del equipo no debe ser nulo";
    public static final String NOT_BLANK_NAME_TEAM = "El nombre del equipo no puede estar en blanco";
    public static final String NOT_BLANK_DESCRIPTION_TEAM = "La descripción del equipo no puede estar en blanco";
    public static final String INVALID_SIZE_TEAM = "El tamaño del equipo debe ser entre 7 y 12 jugadores";
    public static final String NOT_BLANK_LIDER = "El líder del equipo no puede estar en blanco";
}
