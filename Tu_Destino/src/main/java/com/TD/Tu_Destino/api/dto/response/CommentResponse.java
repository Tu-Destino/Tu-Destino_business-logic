package com.TD.Tu_Destino.api.dto.response;

import java.time.LocalDate;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String comment;
    private LocalDate date;
    private UserResponse user;
    private PlaceResponse place;
}
