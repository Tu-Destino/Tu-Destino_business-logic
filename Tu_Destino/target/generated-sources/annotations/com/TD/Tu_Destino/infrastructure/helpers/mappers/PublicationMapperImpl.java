package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.PublicationRequest;
import com.TD.Tu_Destino.api.dto.response.PublicationResponse;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.domain.entities.Publication;
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
public class PublicationMapperImpl implements PublicationMapper {

    @Override
    public Publication toEntity(PublicationRequest request) {
        if ( request == null ) {
            return null;
        }

        Publication.PublicationBuilder publication = Publication.builder();

        publication.title( request.getTitle() );
        publication.description( request.getDescription() );
        publication.tags( request.getTags() );
        publication.url_img( request.getUrl_img() );
        publication.enum_status( request.getEnum_status() );

        return publication.build();
    }

    @Override
    public PublicationResponse toResponse(Publication entity) {
        if ( entity == null ) {
            return null;
        }

        PublicationResponse.PublicationResponseBuilder publicationResponse = PublicationResponse.builder();

        publicationResponse.id( entity.getId() );
        publicationResponse.title( entity.getTitle() );
        publicationResponse.description( entity.getDescription() );
        publicationResponse.tags( entity.getTags() );
        publicationResponse.url_img( entity.getUrl_img() );
        publicationResponse.publication_date( entity.getPublication_date() );
        publicationResponse.enum_status( entity.getEnum_status() );
        publicationResponse.user( userToUserResponse( entity.getUser() ) );

        return publicationResponse.build();
    }

    @Override
    public List<PublicationResponse> toListResponse(List<Publication> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PublicationResponse> list = new ArrayList<PublicationResponse>( entityList.size() );
        for ( Publication publication : entityList ) {
            list.add( toResponse( publication ) );
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
}
