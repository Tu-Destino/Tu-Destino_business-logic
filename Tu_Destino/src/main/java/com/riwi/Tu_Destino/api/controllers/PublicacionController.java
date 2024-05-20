package com.riwi.Tu_Destino.api.controllers;


import com.riwi.Tu_Destino.api.dto.requests.PublicacionRequest;
import com.riwi.Tu_Destino.api.dto.response.PublicacionResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPublicationService;
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
@RequestMapping(path = "/publication")
@AllArgsConstructor

public class PublicacionController {
    @Autowired
    private final IPublicationService publicationService;

    @Operation(summary = "Get all publications", description = "Retrieve a list of all publications in the system.")
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<PublicacionResponse>> get(){
        return ResponseEntity.ok(this.publicationService.getAll());
    }
    @Operation(summary = "Get a publication by ID", description = "Retrieve a publication by its ID. \n\nParameters: \n- id: ID of the publication to be retrieved (Path Variable)")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public  ResponseEntity<PublicacionResponse> getById(
            @PathVariable Long id
    ){
        return  ResponseEntity.ok(this.publicationService.getById(id));
    }
    @Operation(summary = "Create a new publication", description = "Create a new publication. \n\nRequest Body: \n- publication: Publication object to be created")
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<PublicacionResponse> insert(
            @Validated @RequestBody PublicacionRequest request
    ){
        return ResponseEntity.ok(this.publicationService.create(request));

    }

    @Operation(summary = "Delete a publication", description = "Delete a publication by its ID. \n\nParameters: \n- id: ID of the publication to be deleted (Path Variable)")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete (@PathVariable Long id)
    {
        Map<String,String> response = new HashMap<>();
        response.put("message","Se elimino el publicación correctamente");
        this.publicationService.delete(id);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Update a publication", description = "Update an existing publication. \n\nParameters: \n- id: ID of the publication to be updated (Path Variable) \n\nRequest Body: \n- publication: Updated publication object")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @PutMapping(path = "/{id}")
    public ResponseEntity<PublicacionResponse> update(
            @PathVariable Long id,
            @Validated @RequestBody PublicacionRequest Request
    ){
        return  ResponseEntity.ok(this.publicationService.update(id,Request));
    }


}
