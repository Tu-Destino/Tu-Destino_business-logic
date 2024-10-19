package com.TD.Tu.Destino.infrastructure.abstract_service;

import com.TD.Tu.Destino.api.dtos.request.LabelsRequest;
import com.TD.Tu.Destino.api.dtos.response.PostDiscoverResponse;

import java.util.List;

public interface IPostDiscoverService {

    List<PostDiscoverResponse> findByTags(LabelsRequest labelsRequest);
}
