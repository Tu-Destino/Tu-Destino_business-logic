package com.TD.Tu_Destino.infrastructure.abstract_services;

import com.TD.Tu_Destino.api.dto.requests.CookiesRequest;
import com.TD.Tu_Destino.api.dto.response.CookiesResponse;

public interface ICookiesService extends CrudService<CookiesRequest, CookiesResponse,String>{
    public CookiesResponse getById(String id);
}
