package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.PlaceRequest;
import com.riwi.Tu_Destino.api.dto.response.PlaceResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPlaceService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all places", description = "Retrieve a list of all places in the system.")
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<PlaceResponse>> get(){
        return ResponseEntity.ok(this.placeService.getAll());
    }
<<<<<<< HEAD
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/")
=======

    @Operation(summary = "Get a place by ID", description = "Retrieve a place by its ID. \n\nParameters: \n- id: ID of the place to be retrieved (Path Variable)")
    @CrossOrigin(origins = "*")
>>>>>>> f0e659d8b559d31d01b0dc71084fa42ca3e4d3a8
    @GetMapping(path = "/{id}")
    public ResponseEntity<PlaceResponse> getById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.placeService.getById(id));
    }
<<<<<<< HEAD
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/")
=======
    @Operation(summary = "Create a new place", description = "Create a new place. \n\nRequest Body: \n- place: Place object to be created ")
    @CrossOrigin(origins = "*")
>>>>>>> f0e659d8b559d31d01b0dc71084fa42ca3e4d3a8
    @PostMapping
    public ResponseEntity<PlaceResponse> insert(
            @Validated @RequestBody PlaceRequest place
            ){
        return ResponseEntity.ok(this.placeService.create(place));
    }
<<<<<<< HEAD
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/")
=======

    @Operation(summary = "Delete a place", description = "Delete a place by its ID. \n\nParameters: \n- id: ID of the place to be deleted (Path Variable)")
    @CrossOrigin(origins = "*")
>>>>>>> f0e659d8b559d31d01b0dc71084fa42ca3e4d3a8
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.placeService.delete(id);
        return ResponseEntity.noContent().build();
    }
<<<<<<< HEAD
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/")
=======

    @Operation(summary = "Update a place", description = "Update an existing place. \n\nParameters: \n- id: ID of the place to be updated (Path Variable) \n\nRequest Body: \n- place: Updated place object")
    @CrossOrigin(origins = "*")
>>>>>>> f0e659d8b559d31d01b0dc71084fa42ca3e4d3a8
    @PutMapping(path = "/{id}")
    public ResponseEntity<PlaceResponse>update(
            @PathVariable Long id,
            @Validated @RequestBody PlaceRequest place
    ){
        return ResponseEntity.ok(this.placeService.update(id,place));
    }
}
