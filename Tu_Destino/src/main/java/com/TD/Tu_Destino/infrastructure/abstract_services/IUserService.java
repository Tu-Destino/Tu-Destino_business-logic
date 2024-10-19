package com.TD.Tu_Destino.infrastructure.abstract_services;

import com.TD.Tu_Destino.api.dto.requests.UserRequest;
import com.TD.Tu_Destino.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, String>{
}
