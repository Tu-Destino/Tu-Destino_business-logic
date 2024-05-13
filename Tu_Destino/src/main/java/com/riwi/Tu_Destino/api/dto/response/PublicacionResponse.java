package com.riwi.Tu_Destino.api.dto.response;

import com.riwi.Tu_Destino.Util.enums.StatePublicacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionResponse {

    private Long id;
    private String titulo;
    private String descripcion;
    private String etiquetas;
    private String url_img;
    private LocalDateTime fecha_publicacion;
    private StatePublicacion enum_estado;

    //For merge
    private String user_id;
}
