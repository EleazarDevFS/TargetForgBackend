package com.tuxitech.mx.targetforg.mapper.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tuxitech.mx.targetforg.dto.request.PersonRequest;
import com.tuxitech.mx.targetforg.dto.response.person.PersonResponse;
import com.tuxitech.mx.targetforg.mapper.BaseMapper;
import com.tuxitech.mx.targetforg.model.person.GenderModel;
import com.tuxitech.mx.targetforg.model.person.PersonModel;

@Component
public class PersonMapper implements BaseMapper<PersonResponse,PersonRequest,PersonModel>{
    @Autowired
    private GenderMapper genderMapper;
    
    @Override
    public PersonModel toEntity(PersonRequest dto) {
        return PersonModel.builder()
                .curp(dto.getCurp())
                .birthDate(dto.getBirthDate())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .firstLastName(dto.getFirstLastName())
                .secondLastName(dto.getSecondLastName())
                .mail(dto.getMail())
                .phone(dto.getPhone())
                .gender(genderMapper.toEntity(dto.getGender()))
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<PersonResponse> toDtos(List<PersonModel> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDtos'");
    }

    @Override
    public void updateEntity(PersonRequest request, PersonModel entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEntity'");
    }

}
