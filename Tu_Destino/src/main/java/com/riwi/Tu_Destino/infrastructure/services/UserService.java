package com.riwi.Tu_Destino.infrastructure.services;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.UserRequest;
import com.riwi.Tu_Destino.api.dto.response.UserResponse;
import com.riwi.Tu_Destino.domain.entities.User;
import com.riwi.Tu_Destino.domain.repositories.UserRepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;
    @Override
    public void delete(String s) {
        User user = this.find(s);
        this.userRepository.delete(user);
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = this.requestToUser(request, new User());
        return this.entityResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse update(String s, UserRequest request) {
        User user = this.find(s);
        User userUpdate = this.requestToUser(request,user);

        return this.entityResponse(this.userRepository.save(userUpdate));
    }

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> listUser = this.userRepository.findAll().stream().map(this:: entityResponse).collect(Collectors.toList());
        return listUser;
    }

    public User find(String id){
        return this.userRepository.findById(id).orElseThrow(()->new IdNotFoundException("User"));
    }

    @Override
    public UserResponse getById(String id) {
        return this.entityResponse(this.find(id));
    }

    public UserResponse entityResponse(User entity){
        UserResponse response = new UserResponse();

        BeanUtils.copyProperties(entity,response);

        return response;
    }

    public User requestToUser (UserRequest request, User user){
        BeanUtils.copyProperties(request,user);
        return user;
    }



}
