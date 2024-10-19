package com.TD.Tu_Destino.infrastructure.helpers;

import com.TD.Tu_Destino.Util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SupportService<Entity> {
    public Entity findByID(JpaRepository<Entity, Long> repository, Long id, String  message){
        return repository.findById(id).orElseThrow(()-> new IdNotFoundException(message));
    }

    public Entity findByUUID(JpaRepository<Entity, String> repository, String id, String  message){
        return repository.findById(id).orElseThrow(()-> new IdNotFoundException(message));
    }
}
