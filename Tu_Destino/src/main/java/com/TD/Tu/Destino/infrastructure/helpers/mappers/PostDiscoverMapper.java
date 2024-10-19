package com.TD.Tu.Destino.infrastructure.helpers.mappers;

import com.TD.Tu.Destino.api.dtos.response.PostDiscoverResponse;
import com.TD.Tu.Destino.domain.entities.PostDiscover;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostDiscoverMapper {


    PostDiscoverResponse toResponse(PostDiscover postDiscover);
}
