package com.TD.Tu_Destino.api.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDiscoverResponse {
    private String id;
    private String title;
    private String description;
    private String tags;
    private String urlImg;
    private PlaceResponse place;
    private  UserResponse user;
}
