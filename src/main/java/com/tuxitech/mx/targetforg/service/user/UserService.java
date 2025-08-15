package com.tuxitech.mx.targetforg.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tuxitech.mx.targetforg.dto.request.user.UserRequest;
import com.tuxitech.mx.targetforg.dto.response.messages.MessagesResponse;
import com.tuxitech.mx.targetforg.dto.response.team.TeamResponse;
import com.tuxitech.mx.targetforg.dto.response.user.UserResponse;
import com.tuxitech.mx.targetforg.mapper.user.UserMapper;
import com.tuxitech.mx.targetforg.model.team.TeamModel;
import com.tuxitech.mx.targetforg.model.user.UserModel;
import com.tuxitech.mx.targetforg.repository.user.IUserRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    private IUserRepository userRepository;
    private UserMapper userMapper;

    @Transactional
    public UserResponse createUser(@NonNull UserRequest userRequest) throws Exception{
        try {
            Assert.notNull(userRequest, MessagesResponse.NOT_NULL_USER);
            if(userRepository.existsById(userRequest.getId())){
                throw new Exception(MessagesResponse.USER_ALREADY_EXISTS);
            }

            UserModel userModel = userMapper.toEntity(userRequest);
            //Se valida lo que sea necesario antes de guardar
            UserModel userSaved = userRepository.save(userModel);
            return userMapper.toDto(userSaved);
        } catch (Exception e) {
            throw e;
        }
    }   

    @Transactional
    public List<UserResponse> getAllUsers(){
        try {
            List<UserModel> allUsers = userRepository.findAll();
            return allUsers.stream()
            .map(userMapper::toDto)
            .collect(Collectors.toList());
        } catch (Exception e) {
            throw e;// Aquí retornaríamos una excepción personalizada
        }
    }

    @Transactional
    public UserResponse getUserById(Long idUser){
        try {
            return userRepository.findById(idUser)
            .map(userMapper::toDto)
            .orElse(null);
        } catch (Exception e) {
           throw e; 
        }
    }
    
    @Transactional
    public UserModel createUserEntity(UserRequest userRequest){
        Assert.notNull(userRequest, MessagesResponse.NOT_NULL_USER);
        UserResponse existingUser = this.getUserById(userRequest.getId());
        if(existingUser != null){
            return userMapper.toEntity(existingUser);
        }

        UserModel userModel = userMapper.toEntity(existingUser);
        return userRepository.save(userModel);
    }
}
