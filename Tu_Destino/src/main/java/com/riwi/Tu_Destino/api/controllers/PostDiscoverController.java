package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.riwi.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPostDiscoverService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postDiscover")
@AllArgsConstructor
public class PostDiscoverController {
    @Autowired
    private final IPostDiscoverService postDiscoverService;
    @GetMapping
    public ResponseEntity<List<PostDiscoverResponse>> get(){
        return ResponseEntity.ok(this.postDiscoverService.getAll());
    }

    @GetMapping(path = "/{id}")
    public  ResponseEntity<PostDiscoverResponse> getById(
            @PathVariable String id
    ){
        return  ResponseEntity.ok(this.postDiscoverService.getById(id));
    }
    @PostMapping
    public ResponseEntity<PostDiscoverResponse> insert(
            @Validated @RequestBody PostDiscoverRequest request
            ){
        return ResponseEntity.ok(this.postDiscoverService.create(request));

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id)
    {
        this.postDiscoverService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDiscoverResponse> update(
            @PathVariable String id,
            @Validated @RequestBody PostDiscoverRequest postDiscoverRequest
    ){
        return  ResponseEntity.ok(this.postDiscoverService.update(id,postDiscoverRequest));
    }
}
