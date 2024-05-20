package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.riwi.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPostDiscoverService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/postDiscover")
@AllArgsConstructor
public class PostDiscoverController {
    @Autowired
    private final IPostDiscoverService postDiscoverService;

    @Operation(summary = "Get all posts", description = "Retrieve a list of all posts in the system.")
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<PostDiscoverResponse>> get(){
        return ResponseEntity.ok(this.postDiscoverService.getAll());
    }

    @Operation(summary = "Get a post by ID", description = "Retrieve a post by its ID. \n\nParameters: \n- id: ID of the post to be retrieved (Path Variable)")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public  ResponseEntity<PostDiscoverResponse> getById(
            @PathVariable String id
    ){
        return  ResponseEntity.ok(this.postDiscoverService.getById(id));
    }

    @Operation(summary = "Create a new post", description = "Create a new post. \n\nRequest Body: \n- postDiscover: PostDiscover object to be created")
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<PostDiscoverResponse> insert(
            @Validated @RequestBody PostDiscoverRequest request
            ){
        return ResponseEntity.ok(this.postDiscoverService.create(request));

    }

    @Operation(summary = "Delete a post", description = "Delete a post by its ID. \n\nParameters: \n- id: ID of the post to be deleted (Path Variable)")
    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete (@PathVariable String id)
    {
        Map<String,String> response = new HashMap<>();
        response.put("message","Se elimino el post correctamente");
        this.postDiscoverService.delete(id);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Update a post", description = "Update an existing post. \n\nParameters: \n- id: ID of the post to be updated (Path Variable) \n\nRequest Body: \n- postDiscover: Updated PostDiscover object")
    @CrossOrigin(origins = "*")
    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDiscoverResponse> update(
            @PathVariable String id,
            @Validated @RequestBody PostDiscoverRequest postDiscoverRequest
    ){
        return  ResponseEntity.ok(this.postDiscoverService.update(id,postDiscoverRequest));
    }
}
