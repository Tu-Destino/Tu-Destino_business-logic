package com.riwi.Tu_Destino.infrastructure.abstract_services;

import com.riwi.Tu_Destino.api.dto.requests.PlaceRequest;
import com.riwi.Tu_Destino.api.dto.response.PlaceResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.CrudService;

public interface IPlaceService extends CrudService<PlaceRequest, PlaceResponse, Long> {
    public PlaceResponse getById(Long id);
}
