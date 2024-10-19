package com.TD.Tu_Destino.infrastructure.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.TD.Tu_Destino.api.dto.requests.CommentRequest;
import com.TD.Tu_Destino.api.dto.response.CommentResponse;
import com.TD.Tu_Destino.api.dto.response.PlaceResponse;
import com.TD.Tu_Destino.api.dto.response.UserResponse;
import com.TD.Tu_Destino.infrastructure.abstract_services.ICommentService;
import com.TD.Tu_Destino.domain.entities.User;
import com.TD.Tu_Destino.domain.repositories.UserRepository;
import com.TD.Tu_Destino.infrastructure.helpers.SupportService;
import com.TD.Tu_Destino.infrastructure.helpers.mappers.CommentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TD.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.TD.Tu_Destino.domain.entities.Comment;
import com.TD.Tu_Destino.domain.entities.Place;
import com.TD.Tu_Destino.domain.repositories.CommentRepository;
import com.TD.Tu_Destino.domain.repositories.PlaceRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CommentService implements ICommentService {

    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final PlaceRepository placeRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final CommentMapper commentMapper;
    @Autowired
    private final SupportService<Comment> commentSupport;
    @Autowired
    private final SupportService<Place> placeSupport;
    @Autowired
    private final SupportService<User> userSupport;



    @Override
    public CommentResponse create(CommentRequest request) {
        User user =this.userSupport.findByUUID(this.userRepository,request.getUser_id(),"User");
        Place place = this.placeSupport.findByID(this.placeRepository,request.getPlace_id(),"Place");

        Comment comment =this.commentMapper.toEntity(request);
        comment.setPlace(place);
        comment.setUser(user);
        comment.setDate(LocalDate.now());
        return this.commentMapper.toResponse(this.commentRepository.save(comment));
    }


    @Override
    public CommentResponse update(Long id, CommentRequest request) {
        Comment comment = this.commentSupport.findByID(this.commentRepository,id,"Comment");
        if (!comment.getUser().getId().equals(request.getUser_id())){
            User user =this.userSupport.findByUUID(this.userRepository,request.getUser_id(),"User");
            comment.setUser(user);
        }
        if (comment.getPlace().getId() != request.getPlace_id() ){
            Place place = this.placeSupport.findByID(this.placeRepository,request.getPlace_id(),"Place");
            comment.setPlace(place);
        }
        BeanUtils.copyProperties(request,comment);
        return this.commentMapper.toResponse(this.commentRepository.save(comment));
    }


    @Override
    public List<CommentResponse> getAll() {
        return this.commentMapper.toListResponse(this.commentRepository.findAll());
    }

    @Override
    public List<CommentResponse> getAllByIdPlace(Long idPLace) {
        return this.commentMapper.toListResponse(this.commentRepository.findAllByPlace_id(idPLace));
    }
    @Override
    public CommentResponse find(Long id){
        return this.commentMapper.toResponse(this.commentSupport.findByID(this.commentRepository,id,"Comment"));
    }

    @Override
    public void delete(Long id) {
     this.commentRepository.delete(this.commentSupport.findByID(this.commentRepository,id,"Comment"));
    }


}
