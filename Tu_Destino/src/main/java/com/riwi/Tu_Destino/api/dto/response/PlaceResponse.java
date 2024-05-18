package com.riwi.Tu_Destino.api.dto.response;

import com.riwi.Tu_Destino.Util.enums.Enum_Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponse {
    private Long id;
    private Enum_Type enum_tipo;
    private String titulo;
    private String detalles;
    private String precio;
    private String horario;
    private String direccion;
    private String link_direccion;
    private String vr;
    private String web;
    private String telefono;
    private double puntuacion;
    private String info;
    private String btn_url;


}
