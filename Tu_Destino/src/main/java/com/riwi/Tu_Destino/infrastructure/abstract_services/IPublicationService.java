package com.riwi.Tu_Destino.infrastructure.abstract_services;

import com.riwi.Tu_Destino.api.dto.requests.PublicacionRequest;
import com.riwi.Tu_Destino.api.dto.response.PublicacionResponse;

public interface IPublicationService  extends CrudService<PublicacionRequest, PublicacionResponse,Long>{
    public PublicacionResponse getById(Long id);
}
