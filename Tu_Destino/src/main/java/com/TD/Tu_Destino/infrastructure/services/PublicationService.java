package com.TD.Tu_Destino.infrastructure.services;

import com.TD.Tu_Destino.api.dto.requests.PublicationRequest;
import com.TD.Tu_Destino.api.dto.response.PublicationResponse;
import com.TD.Tu_Destino.infrastructure.abstract_services.IPublicationService;
import com.TD.Tu_Destino.Util.enums.StatusPublication;
import com.TD.Tu_Destino.domain.entities.Publication;
import com.TD.Tu_Destino.domain.entities.User;
import com.TD.Tu_Destino.domain.repositories.PublicacionRepository;
import com.TD.Tu_Destino.domain.repositories.UserRepository;
import com.TD.Tu_Destino.infrastructure.helpers.SupportService;
import com.TD.Tu_Destino.infrastructure.helpers.mappers.PublicationMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService implements IPublicationService {
    @Autowired
    private final PublicacionRepository publicacionRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PublicationMapper publicationMapper;
    @Autowired
    private final SupportService<Publication> publicationSupport;
    @Autowired
    private final SupportService<User> UserSupport;

    @Override
    public PublicationResponse create(PublicationRequest request) {
        User user = this.UserSupport.findByUUID(this.userRepository,request.getUser_id(),"User");

        Publication publication = this.publicationMapper.toEntity(request);
        publication.setUser(user);
        publication.setEnum_status(StatusPublication.PENDIENTE);
        publication.setPublication_date(LocalDateTime.now());
        return this.publicationMapper.toResponse(this.publicacionRepository.save(publication));
    }

    @Override
    public PublicationResponse update(Long aLong, PublicationRequest request) {

        Publication publication =this.publicationSupport.findByID(this.publicacionRepository,aLong,"Publication");
        if (!publication.getUser().getId().equals(request.getUser_id())){
            User user =this.UserSupport.findByUUID(this.userRepository,request.getUser_id(),"User");
            publication.setUser(user);

        }
        BeanUtils.copyProperties(request,publication);


        return this.publicationMapper.toResponse(this.publicacionRepository.save(publication));

    }

    @Override
    public List<PublicationResponse> getAll() {
        return this.publicationMapper.toListResponse(this.publicacionRepository.findAll());
    }

    @Override
    public PublicationResponse find(Long id){
       return this.publicationMapper.toResponse(this.publicationSupport.findByID(this.publicacionRepository,id,"Publication"));
    }
    @Override
    public void delete(Long aLong) {
        this.publicacionRepository.delete(this.publicationSupport.findByID(this.publicacionRepository,aLong,"Publication"));
    }

}
