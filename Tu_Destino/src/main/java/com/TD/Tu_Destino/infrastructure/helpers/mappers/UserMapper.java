package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.UserRequest;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends GenericMapper<UserRequest, UserResponse, User>{
}
