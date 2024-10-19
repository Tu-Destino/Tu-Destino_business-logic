package com.TD.Tu.Destino.api.dtos.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDiscoverResponse {

    private String id;
    private String title;
    private String description;
    private String tags;
    private String urlImg;
}
