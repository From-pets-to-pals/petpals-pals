package com.petpals.pals.repository;

import com.petpals.pals.domain.model.pal.Pal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PalsImpl implements Pals {

    private static Map<Long, Pal> palsList = new HashMap<>();
    private  Long idToIncrement = 1L;
    @Override
    public Pal savePal(Pal pal) {
        var toReturn = Pal.builder().technicalId(getIdToIncrement())
                .palMedicalInformation(null)
                .palIdentityInformation(pal.getPalIdentityInformation())
                .palMeasurement(pal.getPalMeasurement())
                .build();
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
