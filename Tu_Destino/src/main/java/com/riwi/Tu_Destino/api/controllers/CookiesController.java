package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.CookiesRequest;
import com.riwi.Tu_Destino.api.dto.response.CookiesResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.ICookiesService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all cookies", description = "Retrieve a list of all cookies in the system.")
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<CookiesResponse>> get(){
        return ResponseEntity.ok(this.cookiesService.getAll());
    }


    @Operation(summary = "Get a cookie by ID", description = "Retrieve a cookie by its ID. \n\nParameters: \n- id: ID of the cookie to be retrieved (Path Variable)")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public ResponseEntity<CookiesResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.cookiesService.getById(id));
    }

    @Operation(summary = "Create a new cookie", description = "Create a new cookie. \n\nRequest Body: \n- cookie: Cookies object to be created")
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<CookiesResponse> insert(
            @Validated @RequestBody CookiesRequest cookies
            ){
        return ResponseEntity.ok(this.cookiesService.create(cookies));
    }

    @Operation(summary = "Delete a cookie", description = "Delete a cookie by its ID. \n\nParameters: \n- id: ID of the cookie to be deleted (Path Variable)")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.cookiesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a cookie", description = "Update an existing cookie. \n\nParameters: \n- id: ID of the cookie to be updated (Path Variable) \n\nRequest Body: \n- cookie: Updated cookie object")
    @CrossOrigin(origins = "*")
    @PutMapping(path = "/{id}")
    private ResponseEntity<CookiesResponse>update(
            @PathVariable String id,
            @Validated @RequestBody CookiesRequest cookies
    ){
        return ResponseEntity.ok(this.cookiesService.update(id, cookies));
    }
}
