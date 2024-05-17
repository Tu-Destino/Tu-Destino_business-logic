package com.riwi.Tu_Destino.infrastructure.services;

import com.riwi.Tu_Destino.Util.enums.StatePublicacion;
import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.PublicacionRequest;
import com.riwi.Tu_Destino.api.dto.response.PublicacionResponse;
import com.riwi.Tu_Destino.api.dto.response.UserResponse;
import com.riwi.Tu_Destino.domain.entities.Publicacion;
import com.riwi.Tu_Destino.domain.entities.User;
import com.riwi.Tu_Destino.domain.repositories.PublicacionRepository;
import com.riwi.Tu_Destino.domain.repositories.UserRepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPublicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PublicationService implements IPublicationService {
    @Autowired
    private final PublicacionRepository publicacionRepository;
    @Autowired
    private final UserRepository uRepository;

    @Override
    public void delete(Long aLong) {
        Publicacion publicacion=this.find(aLong);
        this.publicacionRepository.delete(publicacion);
    }

    @Override
    public PublicacionResponse create(PublicacionRequest request) {
        User user=this.uRepository.findById(request.getUser_id()).orElseThrow(()-> new IdNotFoundException("User"));
        Publicacion publicacion= this.requestToEntity(request,new Publicacion());
        publicacion.setUser_id(user);
        publicacion.setEnum_estado(StatePublicacion.PENDIENTE);
        publicacion.setFecha_publicacion(LocalDateTime.now());
        return this.entityResponse(this.publicacionRepository.save(publicacion));
    }

    @Override
    public PublicacionResponse update(Long aLong, PublicacionRequest request) {
        Publicacion publicacion = this.find(aLong);
        User user = this.uRepository.findById(request.getUser_id()).orElseThrow(()->new IdNotFoundException("User"));
        Publicacion publicacionUpdate =this.requestToEntity(request,publicacion);
        return this.entityResponse(this.publicacionRepository.save(publicacionUpdate));
    }

    @Override
    public List<PublicacionResponse> getAll() {
        List<PublicacionResponse> list =this.publicacionRepository.findAll().stream().map(this::entityResponse).collect(Collectors.toList());
        return list;
    }

    @Override
    public PublicacionResponse getById(Long id) {
        return this.entityResponse(this.find(id));
    }
    private Publicacion find(Long id){
        return this.publicacionRepository.findById(id).orElseThrow(()->new IdNotFoundException("Publication"));
    }

    private PublicacionResponse entityResponse(Publicacion entity){
        PublicacionResponse response = new PublicacionResponse();

        BeanUtils.copyProperties(entity,response);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity.getUser_id(),userResponse);
        response.setUser_id(userResponse);
        return response;
    }
    private Publicacion requestToEntity(PublicacionRequest request, Publicacion publicacion){
        BeanUtils.copyProperties(request,publicacion);
        return publicacion;
    }
}
