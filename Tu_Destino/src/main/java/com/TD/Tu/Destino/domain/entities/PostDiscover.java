package com.TD.Tu.Destino.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDiscover {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 250, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(length = 300, nullable = false)
    private String tags;

    @Column(length = 500, nullable = false)
    private String urlImg;
}
