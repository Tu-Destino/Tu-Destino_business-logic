package com.riwi.Tu_Destino.domain.repositories;

import com.riwi.Tu_Destino.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URepository extends JpaRepository<Usuario,String> {
}
