package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.PostDiscoverRequest;
import com.riwi.Tu_Destino.api.dto.response.PostDiscoverResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPostDiscoverService;
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
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<PostDiscoverResponse>> get(){
        return ResponseEntity.ok(this.postDiscoverService.getAll());
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public  ResponseEntity<PostDiscoverResponse> getById(
            @PathVariable String id
    ){
        return  ResponseEntity.ok(this.postDiscoverService.getById(id));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<PostDiscoverResponse> insert(
            @Validated @RequestBody PostDiscoverRequest request
            ){
        return ResponseEntity.ok(this.postDiscoverService.create(request));

    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete (@PathVariable String id)
    {
        Map<String,String> response = new HashMap<>();
        response.put("message","Se elimino el post correctamente");
        this.postDiscoverService.delete(id);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDiscoverResponse> update(
            @PathVariable String id,
            @Validated @RequestBody PostDiscoverRequest postDiscoverRequest
    ){
        return  ResponseEntity.ok(this.postDiscoverService.update(id,postDiscoverRequest));
    }
}
