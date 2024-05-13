package com.riwi.Tu_Destino.infrastructure.abstract_services;

import com.riwi.Tu_Destino.api.dto.requests.CommentRequest;
import com.riwi.Tu_Destino.api.dto.response.CommentResponse;

public interface ICommentService extends CrudService<CommentRequest,CommentResponse,Long>{
    public CommentResponse getById(Long id);
    
}
