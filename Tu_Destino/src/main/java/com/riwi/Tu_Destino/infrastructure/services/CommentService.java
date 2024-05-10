package com.riwi.Tu_Destino.infrastructure.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.riwi.Tu_Destino.api.dto.response.PlaceResponse;
import com.riwi.Tu_Destino.api.dto.response.UserResponse;
import com.riwi.Tu_Destino.domain.entities.User;
import com.riwi.Tu_Destino.domain.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.requests.CommentRequest;
import com.riwi.Tu_Destino.api.dto.response.CommentResponse;
import com.riwi.Tu_Destino.domain.entities.Comment;
import com.riwi.Tu_Destino.domain.entities.Place;
import com.riwi.Tu_Destino.domain.entities.User;
import com.riwi.Tu_Destino.domain.repositories.CommentRepository;
import com.riwi.Tu_Destino.domain.repositories.PlaceRepository;
import com.riwi.Tu_Destino.domain.repositories.UserRepository;
import com.riwi.Tu_Destino.infrastructure.abstract_services.ICommentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CommentService implements ICommentService{

    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final PlaceRepository placeRepository;
    // 5
    @Autowired
    private final UserRepository uRepository;


    @Override
    public void delete(Long id) {
        
    }

    // 5.1
    // create
    @Override
    public CommentResponse create(CommentRequest request) {
        Place place = this.placeRepository.findById(request.getPlace()).orElseThrow(()-> new IdNotFoundException("Place"));
        User user= this.uRepository.findById(request.getUser()).orElseThrow(()-> new IdNotFoundException("Usuario"));
        Comment comment = this.requestToEntity(request, new Comment());
        comment.setPlace(place);
        comment.setUser(user);
        Date date = new Date(1);
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yy");
        comment.setDate(LocalDate.now());
        return this.entityResponse(this.commentRepository.save(comment));
    }

    //5.2
    // update
    @Override
    public CommentResponse update(Long id, CommentRequest request) {
        Comment comment = this.find(id);
        Place place = this.placeRepository.findById(request.getPlace()).orElseThrow(()->new IdNotFoundException("Place"));
        User user = this.uRepository.findById(request.getUser()).orElseThrow(()->new IdNotFoundException("Usuario"));
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
        PlaceResponse placeResponse= new PlaceResponse();
        UserResponse userResponse=new UserResponse();
        BeanUtils.copyProperties(entity.getPlace(),placeResponse);
        BeanUtils.copyProperties(entity.getUser(),userResponse);
        response.setPlace(placeResponse);
        response.setUser(userResponse);

        return response;
    }

    private Comment requestToEntity(CommentRequest request,Comment comment){
        BeanUtils.copyProperties(request, comment);
        return comment;
    }

    
}
