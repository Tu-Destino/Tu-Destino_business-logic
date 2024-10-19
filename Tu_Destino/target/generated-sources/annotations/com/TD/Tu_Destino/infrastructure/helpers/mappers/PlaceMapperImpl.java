package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.PlaceRequest;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.domain.entities.Place;
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
public class PlaceMapperImpl implements PlaceMapper {

    @Override
    public Place toEntity(PlaceRequest request) {
        if ( request == null ) {
            return null;
        }

        Place.PlaceBuilder place = Place.builder();

        place.enum_type( request.getEnum_type() );
        place.title( request.getTitle() );
        place.details( request.getDetails() );
        place.price( request.getPrice() );
        place.schedule( request.getSchedule() );
        place.address( request.getAddress() );
        place.link_address( request.getLink_address() );
        place.vr( request.getVr() );
        place.web( request.getWeb() );
        place.phone( request.getPhone() );
        if ( request.getRate() != null ) {
            place.rate( request.getRate() );
        }
        place.information( request.getInformation() );
        place.btn_url( request.getBtn_url() );

        return place.build();
    }

    @Override
    public PlaceResponse toResponse(Place entity) {
        if ( entity == null ) {
            return null;
        }

        PlaceResponse.PlaceResponseBuilder placeResponse = PlaceResponse.builder();

        placeResponse.id( entity.getId() );
        placeResponse.enum_type( entity.getEnum_type() );
        placeResponse.title( entity.getTitle() );
        placeResponse.details( entity.getDetails() );
        placeResponse.price( entity.getPrice() );
        placeResponse.schedule( entity.getSchedule() );
        placeResponse.address( entity.getAddress() );
        placeResponse.link_address( entity.getLink_address() );
        placeResponse.vr( entity.getVr() );
        placeResponse.web( entity.getWeb() );
        placeResponse.phone( entity.getPhone() );
        placeResponse.rate( entity.getRate() );
        placeResponse.information( entity.getInformation() );
        placeResponse.btn_url( entity.getBtn_url() );

        return placeResponse.build();
    }

    @Override
    public List<PlaceResponse> toListResponse(List<Place> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PlaceResponse> list = new ArrayList<PlaceResponse>( entityList.size() );
        for ( Place place : entityList ) {
            list.add( toResponse( place ) );
        }

        return list;
    }
}
