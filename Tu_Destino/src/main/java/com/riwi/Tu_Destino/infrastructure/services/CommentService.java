package com.riwi.Tu_Destino.infrastructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.CommentRequest;
import com.riwi.Tu_Destino.api.dto.response.CommentResponse;
import com.riwi.Tu_Destino.domain.entities.Comment;
import com.riwi.Tu_Destino.domain.entities.Place;
import com.riwi.Tu_Destino.domain.entities.Usuario;
import com.riwi.Tu_Destino.domain.repositories.CommentRepository;
import com.riwi.Tu_Destino.domain.repositories.PlaceRepository;
import com.riwi.Tu_Destino.domain.repositories.URepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.ICommentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CommentService implements ICommentService{

    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final PlaceRepository placeRepository;
    @Autowired
    private final URepository uRepository;


    @Override
    public void delete(Long id) {
        
    }

    // create
    @Override
    public CommentResponse create(CommentRequest request) {
        Place place = this.placeRepository.findById(request.getPlace()).orElseThrow(()-> new IdNotFoundException("Place"));
        Usuario user= this.uRepository.findById(request.getUser()).orElseThrow(()-> new IdNotFoundException("Usuario"));
        Comment comment = this.requestToEntity(request, new Comment());
        

        comment.setPlace(place);
        comment.setUser(user);
        
        return this.entityResponse(this.commentRepository.save(comment));
    }

    // update
    @Override
    public CommentResponse update(Long id, CommentRequest request) {
        Comment comment = this.find(id);
        Place place = this.placeRepository.findById(request.getPlace()).orElseThrow(()->new IdNotFoundException("Place"));
        Usuario user = this.uRepository.findById(request.getUser()).orElseThrow(()->new IdNotFoundException("Usuario"));
        Comment postCommentUpdate = this.requestToEntity(request, comment);

        postCommentUpdate.setPlace(place);
        postCommentUpdate.setUser(user);
        
        
        return this.entityResponse(this.commentRepository.save(postCommentUpdate));
    }

    // GetAll
    @Override
    public List<CommentResponse> getAll() {
        List<CommentResponse> list = this.commentRepository.findAll().stream().map(this::entityResponse).collect(Collectors.toList());
        return list;
    }

    // GetById
    @Override
    public CommentResponse getById(Long id) {
        return this.entityResponse(this.find(id));
    }

    //find
    private Comment find(Long id){
        return this.commentRepository.findById(id).orElseThrow(()->new IdNotFoundException("PostDiscover"));
    }

    // entityResponse
    private CommentResponse entityResponse(Comment entity){
        CommentResponse response = new CommentResponse();

        BeanUtils.copyProperties(entity,response);
        BeanUtils.copyProperties(entity,response);

        return response;
    }

    private Comment requestToEntity(CommentRequest request,Comment comment){
        BeanUtils.copyProperties(request, comment);
        return comment;
    }

    
}
