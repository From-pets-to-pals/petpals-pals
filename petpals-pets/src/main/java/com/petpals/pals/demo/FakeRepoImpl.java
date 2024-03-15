package com.petpals.pals.demo;

import com.petpals.pals.domain.model.pal.Pal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FakeRepoImpl implements FakeRepo{

    private static Map<Long, Pal> palsList = new HashMap<>();
    private  Long idToIncrement = 1L;
    @Override
    public Pal savePal(Pal pal) {
        var toReturn = Pal.builder().technicalId(getIdToIncrement()).name(pal.getName()).build();
        setIdToIncrement();
        var newId = getIdToIncrement();
        newId++;
        palsList.put(toReturn.getTechnicalId(), toReturn);
        return toReturn;
    }

    @Override
    public Pal archivePal(Pal pal) {
        pal.setHasDied(true);
        palsList.put(pal.getTechnicalId(), pal);
        return pal;
    }

    @Override
    public Pal updatePal(Pal pal) {
        palsList.put(pal.getTechnicalId(), pal);
        return pal;
    }

    public Long getIdToIncrement() {
        return idToIncrement;
    }

    public void setIdToIncrement() {
        this.idToIncrement++;
    }
}
