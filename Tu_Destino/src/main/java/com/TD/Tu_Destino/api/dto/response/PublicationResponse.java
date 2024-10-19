package com.TD.Tu_Destino.api.dto.response;

import com.TD.Tu_Destino.Util.enums.StatusPublication;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicationResponse {

    private Long id;
    private String title;
    private String description;
    private String tags;
    private String url_img;
    private LocalDateTime publication_date;
    private StatusPublication enum_status;

    //For merge
    private UserResponse user;
}
