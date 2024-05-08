package com.riwi.Tu_Destino.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "cookies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cookies {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer likes;
}
