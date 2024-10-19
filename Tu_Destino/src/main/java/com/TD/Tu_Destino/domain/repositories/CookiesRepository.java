package com.TD.Tu_Destino.domain.repositories;

import com.TD.Tu_Destino.domain.entities.Cookies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookiesRepository extends JpaRepository<Cookies, String> {

}
