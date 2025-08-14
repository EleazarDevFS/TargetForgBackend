package com.tuxitech.mx.targetforg.model.user;

import com.tuxitech.mx.targetforg.model.person.PersonModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @ManyToOne
    @JoinColumn(name = "fk_person", nullable = false)
    PersonModel person;
}
