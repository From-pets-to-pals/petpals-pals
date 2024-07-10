package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.Owners;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class OwnersRepository implements PanacheRepository<Owners> {

    public Long save(Owners owners){
        persistAndFlush(owners);
        return owners.getId();
    }
    
    public Boolean doUserExist(String name, String password){
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("password", password);
        return find("name = :name and password = :password", params).firstResultOptional().isPresent();
    }
    
    public Owners findByReference(String reference){
        return find("reference = :reference", reference).firstResult();
    }
}
