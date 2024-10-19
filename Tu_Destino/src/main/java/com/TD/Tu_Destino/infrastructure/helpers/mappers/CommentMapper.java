package com.TD.Tu_Destino.infrastructure.helpers.mappers;

import com.TD.Tu_Destino.api.dto.requests.CommentRequest;
import com.TD.Tu_Destino.api.dto.response.CommentResponse;
import com.TD.Tu_Destino.domain.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper extends GenericMapper<CommentRequest, CommentResponse, Comment>{
}
