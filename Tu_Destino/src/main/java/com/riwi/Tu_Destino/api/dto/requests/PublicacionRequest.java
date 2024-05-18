package com.riwi.Tu_Destino.api.dto.requests;

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
    @Size(max = 250, message = "You exceeded the number of characters allowed (250)")
    @NotBlank(message = "Required title!")
    private String titulo;
    @Size(max = 1000, message = "You exceeded the number of characters allowed (1000)")
    private String descripcion;
    @Size(max = 300, message = "You exceeded the number of characters allowed (300)")
    @NotBlank(message = "Required label!")
    private String etiquetas;
    @Size(max = 500, message = "You exceeded the number of characters allowed (500)")
    @NotBlank(message = "Required URL image!")
    private String url_img;
    @NotBlank(message = "Required User id!")
    private String user_id;
}
