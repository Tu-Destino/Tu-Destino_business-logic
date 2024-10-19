package com.TD.Tu_Destino.domain.repositories;

import com.TD.Tu_Destino.domain.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    @Query("SELECT p.title FROM place p")
    List<String> findAllTitles();



    Place findByTitle( String placeName);
}
