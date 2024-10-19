package com.TD.Tu_Destino.infrastructure.abstract_services;

import com.TD.Tu_Destino.api.dto.requests.PlaceRequest;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.api.dto.response.SearchListPlaceResponse;

import java.util.List;

public interface IPlaceService extends CrudService<PlaceRequest, PlaceResponse, Long> {
    SearchListPlaceResponse getListNamePlace();
    PlaceResponse findByPlaceName(String placeName);
}
