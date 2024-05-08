package com.riwi.Tu_Destino.infrastructure.services;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.riwi.Tu_Destino.api.dto.response.PlaceResponse;
import com.riwi.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.riwi.Tu_Destino.domain.entities.Place;
import com.riwi.Tu_Destino.domain.entities.PostDiscover;
import com.riwi.Tu_Destino.domain.entities.Usuario;
import com.riwi.Tu_Destino.domain.repositories.PlaceRepository;
import com.riwi.Tu_Destino.domain.repositories.PostDiscoverRepository;
import com.riwi.Tu_Destino.domain.repositories.URepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPostDiscoverService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostDiscoverService implements IPostDiscoverService {
    @Autowired
    private final PostDiscoverRepository postDiscoverRepository;
    @Autowired
    private final PlaceRepository placeRepository;
    @Autowired
    private final URepository uRepository;

    @Override
    public void delete(String string) {
        PostDiscover postDiscover =this.find(string);
        this.postDiscoverRepository.delete(postDiscover);
    }

    @Override
    public PostDiscoverResponse create(PostDiscoverRequest request) {
        Place place = this.placeRepository.findById(request.getPlace()).orElseThrow(()->new IdNotFoundException("Place"));
        Usuario user= this.uRepository.findById(request.getUsuario()).orElseThrow(()->new IdNotFoundException("User"));
        PostDiscover postDiscover= this.requestToEntity(request,new PostDiscover());


        postDiscover.setPlace(place);
        postDiscover.setUser(user);
        System.out.println(place);
        System.out.println( user);
        return this.entityResponse(this.postDiscoverRepository.save(postDiscover));
    }

    @Override
    public PostDiscoverResponse update(String string, PostDiscoverRequest request) {
        PostDiscover postDiscover = this.find(string);
        Place place= this.placeRepository.findById(request.getPlace()).orElseThrow(()->new IdNotFoundException("place"));
        Usuario user = this.uRepository.findById(request.getUsuario()).orElseThrow(()->new IdNotFoundException("User"));
        PostDiscover postDiscoverUpdate=this.requestToEntity(request,postDiscover);
        postDiscoverUpdate.setUser(user);
        postDiscoverUpdate.setPlace(place);
        return this.entityResponse(this.postDiscoverRepository.save(postDiscoverUpdate));
    }

    @Override
    public List<PostDiscoverResponse> getAll() {
        List<PostDiscoverResponse> list = this.postDiscoverRepository.findAll().stream().map(this::entityResponse).collect(Collectors.toList());
        return list;
    }

    @Override
    public PostDiscoverResponse getById(String id) {
        return this.entityResponse(this.find(id));
    }
    private PostDiscover find(String id){
        return this.postDiscoverRepository.findById(id).orElseThrow(()->new IdNotFoundException("PostDiscover"));
    }

    private PostDiscoverResponse entityResponse(PostDiscover entity){
        System.out.println(entity);
        PostDiscoverResponse response = new PostDiscoverResponse();
        BeanUtils.copyProperties(entity,response);
        PlaceResponse placeResponse= new PlaceResponse();
        BeanUtils.copyProperties(entity.getPlace(),placeResponse);
        response.setPlace(placeResponse);

        return response;
    }
    private PostDiscover requestToEntity(PostDiscoverRequest request, PostDiscover postDiscover){
        BeanUtils.copyProperties(request,postDiscover);
        return postDiscover;
    }
}
