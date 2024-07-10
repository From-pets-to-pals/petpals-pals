package com.petpals.persistence.repositories;

import com.petpals.persistence.dto.AuthOwnerDto;
import com.petpals.persistence.entities.Owners;
import com.petpals.shared.utils.PasswordUtils;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class OwnersRepository implements PanacheRepository<Owners> {

    public Long save(Owners owners){
        persistAndFlush(owners);
        return owners.getId();
    }

    public String authOwner(AuthOwnerDto authOwnerDto) {
        Owners owner = find("email", authOwnerDto.getEmail()).firstResult();

        if (owner == null || rehashedPasswordIsEqual(authOwnerDto, owner)) {
            return null;
        }

        return owner.getReference();
    }

    public Boolean rehashedPasswordIsEqual(AuthOwnerDto dto, Owners owner) {
        return !owner.getPassword().equals(PasswordUtils.hashPassword(dto.getPassword(), owner.getSalt()));
    }
}
