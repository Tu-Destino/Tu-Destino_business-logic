package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.CookiesRequest;
import com.riwi.Tu_Destino.api.dto.response.CookiesResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.ICookiesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cookies")
@AllArgsConstructor
public class CookiesController {

    @Autowired
    private final ICookiesService cookiesService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<CookiesResponse>> get(){
        return ResponseEntity.ok(this.cookiesService.getAll());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public ResponseEntity<CookiesResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.cookiesService.getById(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<CookiesResponse> insert(
            @Validated @RequestBody CookiesRequest cookies
            ){
        return ResponseEntity.ok(this.cookiesService.create(cookies));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.cookiesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/{id}")
    private ResponseEntity<CookiesResponse>update(
            @PathVariable String id,
            @Validated @RequestBody CookiesRequest cookies
    ){
        return ResponseEntity.ok(this.cookiesService.update(id, cookies));
    }
}
