package com.riwi.Tu_Destino.infrastructure.abstract_services;

import com.riwi.Tu_Destino.api.dto.requests.UserRequest;
import com.riwi.Tu_Destino.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, String>{
    public UserResponse getById(String id);
}
