package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.TD.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.TD.Tu_Destino.domain.entities.PostDiscover;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostDiscoverMapper extends GenericMapper<PostDiscoverRequest, PostDiscoverResponse, PostDiscover>{
}
