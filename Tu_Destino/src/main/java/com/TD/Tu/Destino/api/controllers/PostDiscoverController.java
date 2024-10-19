package com.TD.Tu.Destino.api.controllers;

import com.TD.Tu.Destino.api.dtos.request.LabelsRequest;
import com.TD.Tu.Destino.api.dtos.response.PostDiscoverResponse;
import com.TD.Tu.Destino.infrastructure.abstract_service.IPostDiscoverService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Filter")
@AllArgsConstructor
public class PostDiscoverController {

    @Autowired
    IPostDiscoverService postDiscoverService;

    @GetMapping
    public ResponseEntity<List<PostDiscoverResponse>> getByTags(
            @RequestBody @Validated LabelsRequest lisTags
            ){
        return ResponseEntity.ok(this.postDiscoverService.findByTags(lisTags));

    }

}
