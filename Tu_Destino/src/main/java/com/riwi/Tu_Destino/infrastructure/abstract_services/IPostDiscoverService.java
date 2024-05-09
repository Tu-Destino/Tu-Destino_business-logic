package com.riwi.Tu_Destino.infrastructure.abstract_services;

import com.riwi.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.riwi.Tu_Destino.api.dto.response.PostDiscoverResponse;

public interface IPostDiscoverService extends CrudService<PostDiscoverRequest, PostDiscoverResponse,String> {
    public PostDiscoverResponse getById(String id);
}
