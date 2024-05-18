package com.riwi.Tu_Destino.api.dto.requests;

import com.riwi.Tu_Destino.Util.enums.Enum_Type;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRequest {
    @NotNull(message = "The place type can't be null")
    private Enum_Type enum_tipo;

    @Size(max = 100, message = "You exceeded the number of characters allowed (100)")
    @NotBlank(message = "This attribute is required")
    private String titulo;

    @Size(min = 20, message = "The details must be more than 20 characters")
    @Size(max = 2000, message = "You exceeded the number of characters allowed (2000)")
    @NotBlank(message = "This attribute is required")
    private String detalles;

    @Size(max = 100, message = "You exceeded the number of characters allowed (100)")
    @NotBlank(message = "This attribute is required")
    private String precio;

    @Size(max = 100, message = "You exceeded the number of characters allowed (100)")
    private String horario;

    @Size(max = 100, message = "You exceeded the number of characters allowed (100)")
    @NotBlank(message = "This attribute is required")
    private String direccion;

    @Size(max = 100, message = "You exceeded the number of characters allowed (100)")
    private String link_direccion;

    @Size(max = 1000, message = "You exceeded the number of characters allowed (1000)")
    private String vr;

    @Size(max = 120, message = "You exceeded the number of characters allowed (120)")
    private String web;

    @Size(max = 100, message = "You exceeded the number of characters allowed (100)")
    private String telefono;

    @NotNull(message = "The place must have qualification")
    @PositiveOrZero(message = "The qualification can't be negative")
    private Double puntuacion;

    @Size(min = 20, message = "The info must be more than 20 characters")
    @Size(max = 2000, message = "You exceeded the number of characters allowed (2000)")
    @NotBlank(message = "This attribute is required")
    private String info;

    @Size(max = 1000,message = "You exceeded the number of characters allowed (2000)")
    private String btn_url;
}
