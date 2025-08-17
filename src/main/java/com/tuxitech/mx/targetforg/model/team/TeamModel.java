package com.tuxitech.mx.targetforg.model.team;

import com.tuxitech.mx.targetforg.model.user.UserModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private Long idTeam;

    @Column(name = "name_team", length = 60, nullable = false)
    private String nameTeam;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "size_team", nullable = false)
    private int sizeTeam;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "lider_id", nullable = false)
    private UserModel lider;
}
