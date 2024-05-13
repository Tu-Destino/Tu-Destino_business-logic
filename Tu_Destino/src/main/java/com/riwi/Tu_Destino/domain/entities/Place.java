package com.riwi.Tu_Destino.domain.entities;

import com.riwi.Tu_Destino.Util.enums.Enum_Type;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "place")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum_Type enum_tipo;
    @Column(nullable = false, length = 100)
    private String titulo;
    @Column(nullable = false,length = 2000)
    private String detalles;
    @Column(length = 100,nullable = false)
    private String precio;
    @Column(length = 100)
    private String horario;
    @Column(length = 100,nullable = false)
    private String direccion;
    @Column(length = 100)
    private String link_direccion;
    @Column(length = 1000)
    private String vr;
    @Column(length = 100)
    private String web;
    @Column(length = 100)
    private String telefono;
    @Column(length = 100,nullable = false)
    private double puntuacion;
    @Column(nullable = false ,length = 2000)
    private String info ;
    @Column(length = 1000)
    private String btn_url;

    @OneToMany(mappedBy = "place",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<PostDiscover> postDiscovers;

    @OneToMany(mappedBy = "place",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Comment> comment;

}
