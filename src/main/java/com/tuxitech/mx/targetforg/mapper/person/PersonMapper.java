package com.tuxitech.mx.targetforg.mapper.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tuxitech.mx.targetforg.dto.request.person.PersonRequest;
import com.tuxitech.mx.targetforg.dto.response.person.PersonResponse;
import com.tuxitech.mx.targetforg.mapper.BaseMapper;
import com.tuxitech.mx.targetforg.model.person.GenderModel;
import com.tuxitech.mx.targetforg.model.person.PersonModel;
import com.tuxitech.mx.targetforg.repository.person.IGenderRepository;

@Component
public class PersonMapper implements BaseMapper<PersonResponse,PersonRequest,PersonModel>{
    @Autowired
    private GenderMapper genderMapper;
    
    @Autowired
    private IGenderRepository genderRepository;
    
    @Override
    public PersonModel toEntity(PersonRequest dto) {
        // Buscar el género existente en lugar de crear uno nuevo
        GenderModel existingGender = genderRepository.findById(dto.getGender().getIdGender())
            .orElseThrow(() -> new RuntimeException("Género no encontrado con ID: " + dto.getGender().getIdGender()));
            
        return PersonModel.builder()
                .curp(dto.getCurp())
                .birthDate(dto.getBirthDate())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .firstLastName(dto.getFirstLastName())
                .secondLastName(dto.getSecondLastName())
                .mail(dto.getMail())
                .phone(dto.getPhone())
                .gender(existingGender)
                .build();
    }


    public PersonModel toEntity(PersonResponse dto){
        return PersonModel.builder()
                .curp(dto.getCurp())
                .birthDate(dto.getBirthDate())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .firstLastName(dto.getFirstLastName())
                .secondLastName(dto.getSecondLastName())
                .mail(dto.getMail())
                .phone(dto.getPhone())
                .gender(GenderModel.builder().gender(dto.getGender().getGender())
                        .idGender(dto.getGender().getIdGender()).build())
                .build();
    }

    @Override
    public PersonResponse toDto(PersonModel entity) {
        return PersonResponse.builder()
                .birthDate(entity.getBirthDate())
                .curp(entity.getCurp())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .firstLastName(entity.getFirstLastName())
                .secondLastName(entity.getSecondLastName())
                .mail(entity.getMail())
                .phone(entity.getPhone())
                .gender(genderMapper.toDto(entity.getGender()))
                .build();
    }

    @Override
    public List<PersonResponse> toDtos(List<PersonModel> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateEntity(PersonRequest request, PersonModel entity) {
        entity.setCurp(request.getCurp());
        entity.setBirthDate(request.getBirthDate());
        entity.setFirstName(request.getFirstName());
        entity.setSecondName(request.getSecondName());
        entity.setFirstLastName(request.getFirstLastName());
        entity.setSecondLastName(request.getSecondLastName());
        entity.setMail(request.getMail());
        entity.setPhone(request.getPhone());
        genderMapper.updateEntity(request.getGender(), entity.getGender());
    }

}
