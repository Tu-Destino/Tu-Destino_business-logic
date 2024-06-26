package com.riwi.Tu_Destino.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDiscoverResponse {
    private String id;
    private String titulo;
    private String descripcion;
    private String etiquetas;
    private String urlImg;
    private PlaceResponse place;
    private  UserResponse user;
}
