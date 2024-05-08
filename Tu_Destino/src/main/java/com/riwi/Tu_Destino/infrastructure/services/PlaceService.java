package com.riwi.Tu_Destino.infrastructure.services;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.PlaceRequest;
import com.riwi.Tu_Destino.api.dto.response.PlaceResponse;
import com.riwi.Tu_Destino.domain.entities.Place;
import com.riwi.Tu_Destino.domain.repositories.PlaceRepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService implements IPlaceService {
    
    @Autowired
    private final PlaceRepository placeRepository;
    
    @Override
    public void delete(Long aLong) {
    Place place = this.find(aLong);
    this.placeRepository.delete(place);
    }

    @Override
    public PlaceResponse create(PlaceRequest request) {
    Place place=this.requestToPlace(request,new Place());
        return this.entityResponse(this.placeRepository.save(place));
    }

    @Override
    public PlaceResponse update(Long aLong, PlaceRequest request) {
        Place place=this.find(aLong);
        Place placeUpdate= this.requestToPlace(request,place);
        return this.entityResponse(this.placeRepository.save(placeUpdate));
    }

    @Override
    public List<PlaceResponse> getAll() {
        List<PlaceResponse> listPlace = this.placeRepository.findAll().stream().map(this::entityResponse).collect(Collectors.toList());
        return listPlace;
    }

    @Override
    public PlaceResponse getById(Long id) {
        return this.entityResponse(this.find(id));
    }
    
    private  Place find(Long id){
        return this.placeRepository.findById(id).orElseThrow(()->new IdNotFoundException("Place"));
    }

    private PlaceResponse entityResponse(Place entity){
        PlaceResponse response = new PlaceResponse();

        BeanUtils.copyProperties(entity,response);
        BeanUtils.copyProperties(entity,response);
//        response.setVacants(entity.getVacants().stream().map(vacant ->this.vacantToResponse(vacant)).collect(Collectors.toList()));
        return response;
    }

    private Place requestToPlace(PlaceRequest request,Place place){
        BeanUtils.copyProperties(request,place);
        return place;
    }

}
