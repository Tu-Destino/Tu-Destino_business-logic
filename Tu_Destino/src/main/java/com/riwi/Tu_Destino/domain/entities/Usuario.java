package com.riwi.Tu_Destino.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "usuarios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<PostDiscover> postDiscovers;
    // private Comment comment;

}
