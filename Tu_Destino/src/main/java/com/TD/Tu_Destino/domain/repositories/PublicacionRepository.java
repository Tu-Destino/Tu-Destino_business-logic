package com.TD.Tu_Destino.domain.repositories;

import com.TD.Tu_Destino.domain.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publication, Long> {
}
