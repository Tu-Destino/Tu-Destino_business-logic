package com.riwi.Tu_Destino.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get all comments", description = "Retrieve a list of all comments in the system.")
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<CommentResponse>> get(){
        return ResponseEntity.ok(this.commentService.getAll());
    }

    // 6.2
    //getById
    @Operation(summary = "Get a comment by ID", description = "Retrieve a comment by its ID. \n\nParameters: \n- id: ID of the comment to be retrieved (Path Variable)")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public ResponseEntity<CommentResponse> getById(
        @PathVariable Long id
    ){
        return ResponseEntity.ok(this.commentService.getById(id));
    }



    // insert
    @Operation(summary = "Create a new comment", description = "Create a new comment. \n\nRequest Body: \n- comment: Comment object to be created")
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<CommentResponse> insert(
        @Validated @RequestBody CommentRequest comment){
            return ResponseEntity.ok(this.commentService.create(comment));
        }

    // eliminar
    @Operation(summary = "Delete a comment", description = "Delete a comment by its ID. \n\nParameters: \n- id: ID of the comment to be deleted (Path Variable)")
    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        response.put("message","Se elimino el post correctamente");
        
        this.commentService.delete(id);
        return ResponseEntity.ok(response);
    }

    //.6.1
    // update
    @Operation(summary = "Update a comment", description = "Update an existing comment. \n\nParameters: \n- id: ID of the comment to be updated (Path Variable) \n\nRequest Body: \n- comment: Updated comment object")
    @CrossOrigin(origins = "*")
    @PutMapping(path = "/{id}")
    public ResponseEntity<CommentResponse>update(
            @PathVariable Long id,
            @Validated @RequestBody CommentRequest commentRequest
    ){
        return ResponseEntity.ok(this.commentService.update(id,commentRequest));
    }
    
}
