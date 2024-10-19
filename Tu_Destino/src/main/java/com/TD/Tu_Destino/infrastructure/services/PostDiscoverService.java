package com.TD.Tu_Destino.infrastructure.services;

import com.TD.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.infrastructure.abstract_services.IPostDiscoverService;
import com.TD.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.TD.Tu_Destino.domain.entities.Place;
import com.TD.Tu_Destino.domain.entities.PostDiscover;
import com.TD.Tu_Destino.domain.entities.User;
import com.TD.Tu_Destino.domain.repositories.PlaceRepository;
import com.TD.Tu_Destino.domain.repositories.PostDiscoverRepository;
import com.TD.Tu_Destino.domain.repositories.UserRepository;
import com.TD.Tu_Destino.infrastructure.helpers.SupportService;
import com.TD.Tu_Destino.infrastructure.helpers.mappers.PostDiscoverMapper;
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
    private final UserRepository userRepository;
    @Autowired
    private final SupportService<User> userSupport;
    @Autowired
    private final SupportService<PostDiscover> postDiscoverSupport;
    @Autowired
    private  final SupportService<Place> placeSupport;
    @Autowired
    private final PostDiscoverMapper postDiscoverMapper;


    @Override
    public PostDiscoverResponse create(PostDiscoverRequest request) {
        Place place = this.placeSupport.findByID(this.placeRepository,request.getPlace_id(),"Place");
        User user = this.userSupport.findByUUID(this.userRepository,request.getUser_id(),"User");

        PostDiscover postDiscover= this.postDiscoverMapper.toEntity(request);
        postDiscover.setPlace(place);
        postDiscover.setUser(user);
        return this.postDiscoverMapper.toResponse(this.postDiscoverRepository.save(postDiscover));
    }

    @Override
    public PostDiscoverResponse update(String id, PostDiscoverRequest request) {
        PostDiscover postDiscover = this.postDiscoverSupport.findByUUID(this.postDiscoverRepository,id,"PostDiscover");

        if (!postDiscover.getUser().getId().equals(request.getUser_id())){
            User user =this.userSupport.findByUUID(this.userRepository,request.getUser_id(),"User");
            postDiscover.setUser(user);
        }
        if (postDiscover.getPlace().getId() != request.getPlace_id() ){
            Place place = this.placeSupport.findByID(this.placeRepository,request.getPlace_id(),"Place");
            postDiscover.setPlace(place);
        }
        BeanUtils.copyProperties(request,postDiscover);
        return this.postDiscoverMapper.toResponse(this.postDiscoverRepository.save(postDiscover));
    }

    @Override
    public List<PostDiscoverResponse> getAll() {
        return this.postDiscoverMapper.toListResponse(this.postDiscoverRepository.findAll());
    }

    @Override
    public PostDiscoverResponse find(String id){
      return this.postDiscoverMapper.toResponse(this.postDiscoverSupport.findByUUID(this.postDiscoverRepository,id,"PostDiscover"));
    }

    @Override
    public void delete(String id) {
        this.postDiscoverRepository.delete(this.postDiscoverSupport.findByUUID(this.postDiscoverRepository,id,"PostDiscover"));
    }
}
