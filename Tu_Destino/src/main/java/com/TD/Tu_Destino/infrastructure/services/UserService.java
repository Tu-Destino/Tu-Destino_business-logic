package com.TD.Tu_Destino.infrastructure.services;

import com.TD.Tu_Destino.api.dto.requests.UserRequest;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.infrastructure.abstract_services.IUserService;
import com.TD.Tu_Destino.domain.entities.User;
import com.TD.Tu_Destino.domain.repositories.UserRepository;
import com.TD.Tu_Destino.infrastructure.helpers.SupportService;
import com.TD.Tu_Destino.infrastructure.helpers.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final SupportService<User> userSupportService;

    @Override
    public UserResponse create(UserRequest request) {
        return this.userMapper.toResponse(this.userRepository.save(this.userMapper.toEntity(request)));
    }

    @Override
    public UserResponse update(String id, UserRequest request) {
        User user = this.userSupportService.findByUUID(this.userRepository,id,"User");

    BeanUtils.copyProperties(request,user);
        return this.userMapper.toResponse(this.userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAll() {
        return this.userMapper.toListResponse(this.userRepository.findAll());
    }
    @Override
    public UserResponse find(String id){
        return this.userMapper.toResponse(this.userSupportService.findByUUID(this.userRepository,id,"User"));
    }
    @Override
    public void delete(String id) {
        this.userRepository.delete(this.userSupportService.findByUUID(this.userRepository,id,"User"));
    }


}
