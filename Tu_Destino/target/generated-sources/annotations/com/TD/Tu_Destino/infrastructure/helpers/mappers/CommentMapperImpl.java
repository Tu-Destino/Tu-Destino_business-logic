package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.CommentRequest;
import com.TD.Tu_Destino.api.dto.response.CommentResponse;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.domain.entities.Comment;
import com.TD.Tu_Destino.domain.entities.Place;
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
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toEntity(CommentRequest request) {
        if ( request == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.comment( request.getComment() );

        return comment.build();
    }

    @Override
    public CommentResponse toResponse(Comment entity) {
        if ( entity == null ) {
            return null;
        }

        CommentResponse.CommentResponseBuilder commentResponse = CommentResponse.builder();

        commentResponse.id( entity.getId() );
        commentResponse.comment( entity.getComment() );
        commentResponse.date( entity.getDate() );
        commentResponse.user( userToUserResponse( entity.getUser() ) );
        commentResponse.place( placeToPlaceResponse( entity.getPlace() ) );

        return commentResponse.build();
    }

    @Override
    public List<CommentResponse> toListResponse(List<Comment> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CommentResponse> list = new ArrayList<CommentResponse>( entityList.size() );
        for ( Comment comment : entityList ) {
            list.add( toResponse( comment ) );
        }

        return list;
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
}
