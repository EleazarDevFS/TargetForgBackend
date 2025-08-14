package com.tuxitech.mx.targetforg.model.person;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "people")
public class PersonModel {
    @Id
    @Column(name = "curp", length = 20, unique=true, nullable = false)
    private String curp; 
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name = "second_name", nullable = true, length = 60)
    private String secondName;
    @Column(name = "lastName", nullable = false, length = 60)
    private String firstLastName;
    @Column(name = "last_name_two", nullable = true, length = 60)
    private String secondLastName;
    @Column(name = "mail", length = 200, unique = true)
    private String  mail;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @ManyToOne
    @JoinColumn(name = "fk_gender")
    private GenderModel gender;

    public String getFullName(){
        StringBuilder fullName = new StringBuilder().append(firstName).append(" ");
        if(org.springframework.util.StringUtils.hasText(secondName)){
            fullName.append(secondName).append(" ");
        }
        return fullName
                .append(firstLastName)
                .append(" ")
                .append(secondLastName)
                .toString();
    }
}
