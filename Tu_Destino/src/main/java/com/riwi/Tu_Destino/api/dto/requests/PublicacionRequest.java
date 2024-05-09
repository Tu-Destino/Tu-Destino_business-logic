package com.riwi.Tu_Destino.api.dto.request;

import com.riwi.Tu_Destino.Util.enums.StatePublicacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicacionRequest {
    @NotBlank(message = "Required title!")
    private String titulo;
    @NotBlank(message = "Required description!")
    private String descripcion;
    @NotBlank(message = "Required label!")
    private String etiquetas;
    @NotBlank(message = "Required URL image!")
    private String url_img;

    private LocalDateTime fecha_publicacion;
    private StatePublicacion enum_estado;

    @Size(max = 40,min = 0)
    @NotBlank(message = "Required User id!")
    private String user_id;
}
