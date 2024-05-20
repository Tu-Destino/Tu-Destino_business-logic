package com.riwi.Tu_Destino.api.controllers;


import com.riwi.Tu_Destino.api.dto.requests.PublicacionRequest;
import com.riwi.Tu_Destino.api.dto.response.PublicacionResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IPublicationService;
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

    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @GetMapping
    public ResponseEntity<List<PublicacionResponse>> get(){
        return ResponseEntity.ok(this.publicationService.getAll());
    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @GetMapping(path = "/{id}")
    public  ResponseEntity<PublicacionResponse> getById(
            @PathVariable Long id
    ){
        return  ResponseEntity.ok(this.publicationService.getById(id));
    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @PostMapping
    public ResponseEntity<PublicacionResponse> insert(
            @Validated @RequestBody PublicacionRequest request
    ){
        return ResponseEntity.ok(this.publicationService.create(request));

    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete (@PathVariable Long id)
    {
        Map<String,String> response = new HashMap<>();
        response.put("message","Se elimino el publicación correctamente");
        this.publicationService.delete(id);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @PutMapping(path = "/{id}")
    public ResponseEntity<PublicacionResponse> update(
            @PathVariable Long id,
            @Validated @RequestBody PublicacionRequest Request
    ){
        return  ResponseEntity.ok(this.publicationService.update(id,Request));
    }


}
