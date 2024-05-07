package com.riwi.Tu_Destino.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "postDiscover")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDiscover {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 70, nullable = false)
    private String titulo;
    @Column(length = 150, nullable = false)
    private String descripcion;
    @Column(length = 110, nullable = false)
    private String etiquetas;
    @Column(length = 200, nullable = false)
    private String urlImg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lugar_id",referencedColumnName = "id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_lugar_id",referencedColumnName = "id")
    private Usuario usuario;

}

