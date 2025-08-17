package com.tuxitech.mx.targetforg.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuxitech.mx.targetforg.model.person.GenderModel;

@Repository
public interface IGenderRepository extends JpaRepository<GenderModel, Long> {
}
