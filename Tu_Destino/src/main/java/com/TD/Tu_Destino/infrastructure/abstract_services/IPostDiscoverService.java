package com.TD.Tu_Destino.infrastructure.abstract_services;

import com.TD.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.TD.Tu_Destino.api.dto.response.PostDiscoverResponse;

public interface IPostDiscoverService extends CrudService<PostDiscoverRequest, PostDiscoverResponse,String> {
}
