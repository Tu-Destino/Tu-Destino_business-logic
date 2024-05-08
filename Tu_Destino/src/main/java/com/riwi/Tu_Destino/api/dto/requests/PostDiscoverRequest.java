package com.riwi.Tu_Destino.api.dto.requests;

import com.riwi.Tu_Destino.domain.entities.Place;
import com.riwi.Tu_Destino.domain.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDiscoverRequest {
    @Size(max = 60,message = "Supera la cantidad de caracteres permitidos")
    @NotBlank(message = "El titulo del Post es requerido")
    private String titulo;
    @Size(max = 150,message = "Supera la cantidad de caracteres permitidos")
    private String descripcion;
    @Size(max = 100,message = "Supera la cantidad de caracteres permitidos")
    @NotBlank(message = "Las etiquetas del Post son requeridas")
    private String etiquetas;
    @Size(max = 200,message = "Supera la cantidad de caracteres permitidos")
    @NotBlank(message = "La url de la imagen del Post es requerida")
    private String urlImg;
    @NotNull(message = "Se requiere el lugar del Post")
    private Long place;
    @NotNull(message = "Se requiere el usuario que hizo el Post")
    private String usuario;
}
