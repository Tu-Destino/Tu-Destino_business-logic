package com.TD.Tu_Destino.domain.repositories;

import com.TD.Tu_Destino.domain.entities.PostDiscover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDiscoverRepository extends JpaRepository<PostDiscover,String> {
}
