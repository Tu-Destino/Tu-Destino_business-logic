package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.UserRequest;
import com.riwi.Tu_Destino.api.dto.response.UserResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService userService;
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @GetMapping
    public ResponseEntity<List<UserResponse>> get(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.userService.getById(id));
    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @PostMapping
    public ResponseEntity<UserResponse>insert(
            @Validated @RequestBody UserRequest user
            ){
        return ResponseEntity.ok(this.userService.create(user));
    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app/Tu-Destino-V3.0")
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse>update(
            @PathVariable String id,
            @Validated @RequestBody UserRequest user
    ){
        return ResponseEntity.ok(this.userService.update(id, user));
    }



}
