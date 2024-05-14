package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.PlaceRequest;
import com.riwi.Tu_Destino.api.dto.response.PlaceResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@AllArgsConstructor
public class PlaceController {
    @Autowired
    private final IPlaceService placeService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<PlaceResponse>> get(){
        return ResponseEntity.ok(this.placeService.getAll());
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public ResponseEntity<PlaceResponse> getById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.placeService.getById(id));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<PlaceResponse> insert(
            @Validated @RequestBody PlaceRequest place
            ){
        return ResponseEntity.ok(this.placeService.create(place));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.placeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/{id}")
    public ResponseEntity<PlaceResponse>update(
            @PathVariable Long id,
            @Validated @RequestBody PlaceRequest place
    ){
        return ResponseEntity.ok(this.placeService.update(id,place));
    }
}
