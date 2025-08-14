package com.tuxitech.mx.targetforg.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuxitech.mx.targetforg.model.user.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{}
