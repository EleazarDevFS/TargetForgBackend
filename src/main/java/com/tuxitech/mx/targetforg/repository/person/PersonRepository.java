package com.tuxitech.mx.targetforg.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuxitech.mx.targetforg.model.person.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, String>{}
