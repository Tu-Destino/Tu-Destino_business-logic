package com.riwi.Tu_Destino.api.dto.requests;

import com.riwi.Tu_Destino.Util.enums.Enum_Type;

import jakarta.validation.constraints.NotBlank;
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
    private Enum_Type enum_tipo;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vacio")
    private String titulo;
    @Size(min = 20, message = "Los detalles deben tener mas de 20 caracteres")
    @NotBlank(message = "Este atributo no puede estar vacio")
    private String detalles;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vacio")
    private String precio;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    private String horario;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vacio")
    private String direccion;
    private String link_direccion;
    private String vr;
    private String web;
    private String telefono;
    @Size(max = 100, message = "superaste el limite de caracteres permitidos")
    @NotBlank(message = "Este atributo no puede estar vacio")
    private double puntuacion;
    @Size(min = 20, message = "La info debe tener mas de 20 caracteres")
    @NotBlank(message = "Este atributo no puede estar vacio")
    private String info;
    private String btn_url;
}
