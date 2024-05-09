package com.riwi.Tu_Destino.domain.repositories;

import com.riwi.Tu_Destino.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
}
