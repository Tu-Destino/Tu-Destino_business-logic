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
public class CommentRequest {
    @NotBlank(message = "Este atributo es obligatorio")
    @Size(min = 20,message = "Tu comentario debe tener mas de 50 caracteres")
    private String comentary;
    @NotNull(message = "Este atributo es obligatorio")
    private Usuario user;
    @NotNull(message = "Este atributo es obligatorio")
    private Place place;
}