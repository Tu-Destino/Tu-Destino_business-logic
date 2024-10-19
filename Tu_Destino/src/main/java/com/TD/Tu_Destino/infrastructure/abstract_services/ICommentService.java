package com.TD.Tu_Destino.infrastructure.abstract_services;

import com.TD.Tu_Destino.api.dto.requests.CommentRequest;
import com.TD.Tu_Destino.api.dto.response.CommentResponse;
import com.TD.Tu_Destino.domain.entities.Comment;

import java.util.List;

public interface ICommentService extends CrudService<CommentRequest, CommentResponse,Long>{
 public List<CommentResponse> getAllByIdPlace (Long idPLace);
}
