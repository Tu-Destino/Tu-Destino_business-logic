package com.TD.Tu_Destino.api.dto.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchListPlaceResponse {
    private List<String> listPlace;
}
