package com.TD.Tu.Destino.domain.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDiscoverRepository {

    /*
    * "SELECT p, (CASE WHEN p.tags LIKE :tag(i) THEN 1 ELSE 0 END ) as relevance FROM PostDiscover p WHERE ( OR p.tags LIKE :tag) ORDER BY relevance DESC"
    * */

}
