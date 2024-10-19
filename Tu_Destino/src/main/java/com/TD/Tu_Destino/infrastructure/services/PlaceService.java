package com.TD.Tu_Destino.infrastructure.services;

import com.TD.Tu_Destino.api.dto.requests.PlaceRequest;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.api.dto.response.SearchListPlaceResponse;
import com.TD.Tu_Destino.infrastructure.abstract_services.IPlaceService;
import com.TD.Tu_Destino.domain.entities.Place;
import com.TD.Tu_Destino.domain.repositories.PlaceRepository;
import com.TD.Tu_Destino.infrastructure.helpers.SupportService;
import com.TD.Tu_Destino.infrastructure.helpers.mappers.PlaceMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceService implements IPlaceService {
    
    @Autowired
    private final PlaceRepository placeRepository;
    @Autowired
    private final PlaceMapper placeMapper;
    @Autowired
    private final SupportService<Place> placeSupportService;
    


    @Override
    public PlaceResponse create(PlaceRequest request) {
    return this.placeMapper.toResponse(this.placeRepository.save(this.placeMapper.toEntity(request)));
    }

    @Override
    public PlaceResponse update(Long aLong, PlaceRequest request) {
        Place place=this.placeSupportService.findByID(this.placeRepository,aLong,"Place");
        BeanUtils.copyProperties(request,place);
        return this.placeMapper.toResponse(this.placeRepository.save(place));
    }

    @Override
    public List<PlaceResponse> getAll() {
       return this.placeMapper.toListResponse(this.placeRepository.findAll());
    }

    @Override
    public PlaceResponse find(Long id) {
    return this.placeMapper.toResponse(this.placeSupportService.findByID(this.placeRepository,id,"Place"));
    }
    @Override
    public void delete(Long aLong) {
        this.placeRepository.delete(this.placeSupportService.findByID(this.placeRepository,aLong,"Place"));
    }

    @Override
    public SearchListPlaceResponse getListNamePlace() {

        return new SearchListPlaceResponse(this.placeRepository.findAllTitles());
    }

    @Override
    public PlaceResponse findByPlaceName(String placeName) {
        return this.placeMapper.toResponse(this.placeRepository.findByTitle(placeName));
    }
}