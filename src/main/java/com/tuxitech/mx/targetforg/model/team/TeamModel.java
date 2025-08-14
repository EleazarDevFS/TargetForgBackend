package com.tuxitech.mx.targetforg.model.team;

import com.tuxitech.mx.targetforg.model.user.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTeam, description, maxSize, minSize;
    
    @ManyToOne
    @JoinColumn(name = "liderId", nullable = false)
    private UserModel lider;
}
