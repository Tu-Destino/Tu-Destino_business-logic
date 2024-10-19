package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.UserRequest;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.domain.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T15:19:00-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( request.getName() );
        user.email( request.getEmail() );
        user.password( request.getPassword() );
        user.enum_rol( request.getEnum_rol() );

        return user.build();
    }

    @Override
    public UserResponse toResponse(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( entity.getId() );
        userResponse.name( entity.getName() );
        userResponse.email( entity.getEmail() );
        userResponse.enum_rol( entity.getEnum_rol() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> toListResponse(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toResponse( user ) );
        }

        return list;
    }
}
