package com.tuxitech.mx.targetforg.service.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tuxitech.mx.targetforg.dto.request.person.PersonRequest;
import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;
import com.tuxitech.mx.targetforg.dto.response.person.PersonResponse;
import com.tuxitech.mx.targetforg.mapper.person.PersonMapper;
import com.tuxitech.mx.targetforg.model.person.PersonModel;
import com.tuxitech.mx.targetforg.repository.person.IPersonRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final IPersonRepository personRepository;
    private final PersonMapper personMapper;


    @Transactional
    public PersonResponse createPerson(@NonNull PersonRequest personRequest) throws Exception{//Para no agregar el throw exception haremos nuestra propia excepción
        try{
            Assert.notNull(personRequest, MessagesResponse.NOT_NULL_PERSON);

            if(personRepository.existsById(personRequest.getCurp())){
                throw new Exception(MessagesResponse.PERSON_ALREADY_EXISTS);
            }

            PersonModel personModel = personMapper.toEntity(personRequest);
            //Aquí se tendría que validar la curp antes de guardar
            PersonModel savedPerson = personRepository.save(personModel);
            return personMapper.toDto(savedPerson);
        }catch(Exception e){
            throw e;// Aquí retornaríamos una excepción personalizada
        }
    }

    @Transactional
    public PersonModel createPersonEntity(PersonRequest personRequest){
        Assert.notNull(personRequest, MessagesResponse.NOT_NULL_PERSON);
        PersonResponse existingPerson = this.getPersonById(personRequest.getCurp());
        if(existingPerson != null){
            return personMapper.toEntity(existingPerson);
        }

        PersonModel personModel = personMapper.toEntity(personRequest);

        return personRepository.save(personModel);

    }

    @Transactional
    public PersonResponse getPersonById(@NonNull String personCurp){
        try{
            return personRepository.findById(personCurp)
            .map(personMapper::toDto)
            .orElse(null);
        }catch(Exception e){
            throw e; // Aquí retornaríamos una excepción personalizada
        }
    }

    @Transactional
    public List<PersonResponse> getAllPerson(){
        try{
            List<PersonModel> allPersons = personRepository.findAll();
            return allPersons.stream()
            .map(personMapper::toDto)
            .collect(Collectors.toList());
        }catch(Exception e){
            throw e; // Aquí retornaríamos una excepción personalizada
        }
    }

    @Transactional
    public PersonResponse updatePerson(@NonNull String idPerson, PersonRequest updatePersonRequest) throws Exception{// Para no agregar el throw exception haremos nuestra propia excepción
        try{
            Assert.notNull(updatePersonRequest, MessagesResponse.UPDATE_PERSON_REQUEST_NULL);
            return personMapper.toDto(updatedPerson(idPerson, updatePersonRequest));
        }catch(Exception e ){
            throw e; // Aquí retornaríamos una excepción personalizada
        }

    }

    @Transactional
    public PersonModel updatedPerson(String idPerson, PersonRequest request) throws Exception{// Para no agregar el throw exception haremos nuestra propia excepción
        PersonModel personModel = personRepository.findById(idPerson)
                .orElseThrow(()-> new Exception());
                personMapper.updateEntity(request, personModel);
                //Tendríamos que validar la CURP antes de guardar
                return personRepository.save(personModel);
    }



}
