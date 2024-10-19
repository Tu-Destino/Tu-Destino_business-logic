package com.TD.Tu_Destino.infrastructure.abstract_services;

import com.TD.Tu_Destino.api.dto.requests.PublicationRequest;
import com.TD.Tu_Destino.api.dto.response.PublicationResponse;

public interface IPublicationService  extends CrudService<PublicationRequest, PublicationResponse,Long>{

}
