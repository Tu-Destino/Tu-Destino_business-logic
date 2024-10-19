package com.TD.Tu.Destino.infrastructure.helpers.mappers;

import com.TD.Tu.Destino.api.dtos.response.PostDiscoverResponse;
import com.TD.Tu.Destino.domain.entities.PostDiscover;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T15:17:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class PostDiscoverMapperImpl implements PostDiscoverMapper {

    @Override
    public PostDiscoverResponse toResponse(PostDiscover postDiscover) {
        if ( postDiscover == null ) {
            return null;
        }

        PostDiscoverResponse.PostDiscoverResponseBuilder postDiscoverResponse = PostDiscoverResponse.builder();

        postDiscoverResponse.id( postDiscover.getId() );
        postDiscoverResponse.title( postDiscover.getTitle() );
        postDiscoverResponse.description( postDiscover.getDescription() );
        postDiscoverResponse.tags( postDiscover.getTags() );
        postDiscoverResponse.urlImg( postDiscover.getUrlImg() );

        return postDiscoverResponse.build();
    }
}
