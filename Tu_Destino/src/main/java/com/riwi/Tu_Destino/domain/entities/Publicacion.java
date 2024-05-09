package com.riwi.Tu_Destino.domain.entities;

import com.riwi.Tu_Destino.Util.enums.StatePublicacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "publicacion")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, nullable = false)
    private String titulo;
    @Column(length = 150, nullable = true)
    private String descripcion;
    @Column(length = 100, nullable = false)
    private String etiquetas;
    @Column(length = 200, nullable = false)
    private String url_img;
    @Column(nullable = false)
    private LocalDateTime fecha_publicacion;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatePublicacion enum_estado;



    // @ManyToOne
    // Unnecessary to return users data from publication
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private String user_id;
}
