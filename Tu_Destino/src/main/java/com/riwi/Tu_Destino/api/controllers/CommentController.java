package com.riwi.Tu_Destino.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.Tu_Destino.api.dto.requests.CommentRequest;
import com.riwi.Tu_Destino.api.dto.response.CommentResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.ICommentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    @Autowired
    private final ICommentService commentService;

    // get
    @CrossOrigin(origins = "https://tu-destino-business-logic.onrender.com")
    @GetMapping
    public ResponseEntity<List<CommentResponse>> get(){
        return ResponseEntity.ok(this.commentService.getAll());
    }

    // 6.2
    //getById
    @CrossOrigin(origins = "https://tu-destino-business-logic.onrender.com")
    @GetMapping(path = "/{id}")
    public ResponseEntity<CommentResponse> getById(
        @PathVariable Long id
    ){
        return ResponseEntity.ok(this.commentService.getById(id));
    }



    // insert
    @CrossOrigin(origins = "https://tu-destino-business-logic.onrender.com")
    @PostMapping
    public ResponseEntity<CommentResponse> insert(
        @Validated @RequestBody CommentRequest comment){
            return ResponseEntity.ok(this.commentService.create(comment));
        }

    // eliminar
    @CrossOrigin(origins = "https://tu-destino-business-logic.onrender.com")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        response.put("message","Se elimino el post correctamente");
        
        this.commentService.delete(id);
        return ResponseEntity.ok(response);
    }

    //.6.1
    // update
    @CrossOrigin(origins = "https://tu-destino-business-logic.onrender.com")
    @PutMapping(path = "/{id}")
    public ResponseEntity<CommentResponse>update(
            @PathVariable Long id,
            @Validated @RequestBody CommentRequest commentRequest
    ){
        return ResponseEntity.ok(this.commentService.update(id,commentRequest));
    }
    
}
