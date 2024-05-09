package com.riwi.Tu_Destino.api.dto.requests;

import com.riwi.Tu_Destino.Util.enums.Enum_Type;

import jakarta.validation.constraints.Min;
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
public class PlaceRequest {
    @NotNull(message = "El tipo del lugar no puede ser nulo")
    private Enum_Type enum_tipo;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vació")
    private String titulo;
    @Size(min = 20, message = "Los detalles deben tener mas de 20 caracteres")
    @NotBlank(message = "Este atributo no puede estar vació")
    private String detalles;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vació")
    private String precio;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    private String horario;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vació")
    private String direccion;
    private String link_direccion;
    private String vr;
    private String web;
    private String telefono;
    @NotNull(message = "El lugar debe de llevar una puntuación")
    @Min(value = 0,message = "La puntuación no puede ser negativa")
    private Double puntuacion;
    @Size(min = 20, message = "La info debe tener mas de 20 caracteres")
    @NotBlank(message = "Este atributo no puede estar vació")
    private String info;
    private String btn_url;
}
