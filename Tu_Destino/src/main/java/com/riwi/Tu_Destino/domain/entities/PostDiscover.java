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
    @Column(length = 250, nullable = false)
    private String titulo;
    @Column(length = 1000, nullable = false)
    private String descripcion;
    @Column(length = 300, nullable = true)
    private String etiquetas;
    @Column(length = 500, nullable = false)
    private String urlImg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id",referencedColumnName = "id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;



}

