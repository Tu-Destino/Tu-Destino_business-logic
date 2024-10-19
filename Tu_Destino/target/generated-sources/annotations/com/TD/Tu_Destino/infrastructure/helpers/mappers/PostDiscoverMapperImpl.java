package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.domain.entities.Place;
import com.TD.Tu_Destino.domain.entities.PostDiscover;
import com.TD.Tu_Destino.domain.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T15:19:01-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class PostDiscoverMapperImpl implements PostDiscoverMapper {

    @Override
    public PostDiscover toEntity(PostDiscoverRequest request) {
        if ( request == null ) {
            return null;
        }

        PostDiscover.PostDiscoverBuilder postDiscover = PostDiscover.builder();

        postDiscover.title( request.getTitle() );
        postDiscover.description( request.getDescription() );
        postDiscover.tags( request.getTags() );
        postDiscover.urlImg( request.getUrlImg() );

        return postDiscover.build();
    }

    @Override
    public PostDiscoverResponse toResponse(PostDiscover entity) {
        if ( entity == null ) {
            return null;
        }

        PostDiscoverResponse.PostDiscoverResponseBuilder postDiscoverResponse = PostDiscoverResponse.builder();

        postDiscoverResponse.id( entity.getId() );
        postDiscoverResponse.title( entity.getTitle() );
        postDiscoverResponse.description( entity.getDescription() );
        postDiscoverResponse.tags( entity.getTags() );
        postDiscoverResponse.urlImg( entity.getUrlImg() );
        postDiscoverResponse.place( placeToPlaceResponse( entity.getPlace() ) );
        postDiscoverResponse.user( userToUserResponse( entity.getUser() ) );

        return postDiscoverResponse.build();
    }

    @Override
    public List<PostDiscoverResponse> toListResponse(List<PostDiscover> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PostDiscoverResponse> list = new ArrayList<PostDiscoverResponse>( entityList.size() );
        for ( PostDiscover postDiscover : entityList ) {
            list.add( toResponse( postDiscover ) );
        }

        return list;
    }

    protected PlaceResponse placeToPlaceResponse(Place place) {
        if ( place == null ) {
            return null;
        }

        PlaceResponse.PlaceResponseBuilder placeResponse = PlaceResponse.builder();

        placeResponse.id( place.getId() );
        placeResponse.enum_type( place.getEnum_type() );
        placeResponse.title( place.getTitle() );
        placeResponse.details( place.getDetails() );
        placeResponse.price( place.getPrice() );
        placeResponse.schedule( place.getSchedule() );
        placeResponse.address( place.getAddress() );
        placeResponse.link_address( place.getLink_address() );
        placeResponse.vr( place.getVr() );
        placeResponse.web( place.getWeb() );
        placeResponse.phone( place.getPhone() );
        placeResponse.rate( place.getRate() );
        placeResponse.information( place.getInformation() );
        placeResponse.btn_url( place.getBtn_url() );

        return placeResponse.build();
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.name( user.getName() );
        userResponse.email( user.getEmail() );
        userResponse.enum_rol( user.getEnum_rol() );

        return userResponse.build();
    }
}
