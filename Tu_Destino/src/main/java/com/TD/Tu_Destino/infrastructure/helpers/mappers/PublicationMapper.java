package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.PublicationRequest;
import com.TD.Tu_Destino.api.dto.response.PublicationResponse;
import com.TD.Tu_Destino.domain.entities.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublicationMapper extends GenericMapper<PublicationRequest, PublicationResponse, Publication>{
}
