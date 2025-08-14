package com.tuxitech.mx.targetforg.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuxitech.mx.targetforg.model.team.TeamModel;

@Repository
public interface ITeamRepository extends JpaRepository<TeamModel, Long> {}
