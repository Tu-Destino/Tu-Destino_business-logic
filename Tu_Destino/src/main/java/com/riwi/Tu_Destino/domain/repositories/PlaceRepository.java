package com.riwi.Tu_Destino.domain.repositories;

import com.riwi.Tu_Destino.domain.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Long> {
}
