package com.riwi.Tu_Destino.infrastructure.services;


import java.util.List;

public interface CrudService<RQ,RS,ID>{
    public void delete(ID id);
    public RS create(RQ request);
    public RS update(ID id,RQ request);
    public List<RS> getAll();

}
