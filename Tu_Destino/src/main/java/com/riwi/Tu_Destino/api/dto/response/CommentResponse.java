package com.riwi.Tu_Destino.api.dto.response;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private LocalDate date;
    private String comentary;
    private UserResponse user;
    private PlaceResponse place;
}
