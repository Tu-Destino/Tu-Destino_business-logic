package com.riwi.Tu_Destino.api.controllers;

import com.riwi.Tu_Destino.api.dto.requests.UserRequest;
import com.riwi.Tu_Destino.api.dto.response.UserResponse;
import com.riwi.Tu_Destino.infrastructure.abstract_services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all users", description = "Retrieve a list of all users in the system.")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @GetMapping
    public ResponseEntity<List<UserResponse>> get(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @Operation(summary = "Get a user by ID", description = "Retrieve a user by their ID. \n\nParameters: \n- id: ID of the user to be retrieved (Path Variable)")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @Operation(summary = "Create a new user", description = "Create a new user. \n\nRequest Body: \n- user: User object to be created")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @PostMapping
    public ResponseEntity<UserResponse>insert(
            @Validated @RequestBody UserRequest user
            ){
        return ResponseEntity.ok(this.userService.create(user));
    }

    @Operation(summary = "Delete a user", description = "Delete a user by their ID. \n\nParameters: \n- id: ID of the user to be deleted (Path Variable)")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a user", description = "Update an existing user. \n\nParameters: \n- id: ID of the user to be updated (Path Variable) \n\nRequest Body: \n- user: Updated user object")
    @CrossOrigin(origins = "https://tu-destino-v3-0-wed.vercel.app")
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse>update(
            @PathVariable String id,
            @Validated @RequestBody UserRequest user
    ){
        return ResponseEntity.ok(this.userService.update(id, user));
    }



}
