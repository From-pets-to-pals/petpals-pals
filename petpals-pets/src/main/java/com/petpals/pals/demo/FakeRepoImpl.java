package com.petpals.pals.demo;

import com.petpals.pals.model.pal.Pal;
import org.springframework.stereotype.Repository;

@Repository
public class FakeRepoImpl implements FakeRepo{

    private  Long idToIncrement = 1L;
    @Override
    public Pal savePal(Pal pal) {
        var toReturn = Pal.builder().technicalId(getIdToIncrement()).name(pal.getName()).build();
        setIdToIncrement();
        var newId = getIdToIncrement();
        newId++;
        return toReturn;
    }

    public Long getIdToIncrement() {
        return idToIncrement;
    }

    public void setIdToIncrement() {
        this.idToIncrement++;
    }
}
