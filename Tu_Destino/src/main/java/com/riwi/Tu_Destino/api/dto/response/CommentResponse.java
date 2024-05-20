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
    private String comment;
    private LocalDate comment_date;
    private UserResponse user;
    private PlaceResponse place;
}
