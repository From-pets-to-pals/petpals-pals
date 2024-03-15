package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.model.pal.Pal;
import com.petpals.pals.domain.model.pal.PalMeasurement;
import com.petpals.pals.domain.model.pal.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDailyRation {
    @Test
    public void testDogDailyRation(){
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        Pal doggo = Pal.builder().specie(Species.DOG).palMeasurement(palMeasurement).build();
        String doggoPalDailyRation = doggo.calculatePalDailyRation();
        Assertions.assertEquals("300", doggoPalDailyRation);
    }

    @Test
    public void testCatDailyRation(){
        PalMeasurement palMeasurement = new PalMeasurement(6.0, 30.0);
        Pal catsu = Pal.builder().specie(Species.CAT).palMeasurement(palMeasurement).build();
        String catsuDailyRation = catsu.calculatePalDailyRation();
        Assertions.assertEquals("240", catsuDailyRation);
    }


    @Test
    public void testFerretDailyRation(){
        PalMeasurement palMeasurement = new PalMeasurement(1.0, 30.0);
        Pal ferret = Pal.builder().specie(Species.FERRET).palMeasurement(palMeasurement).build();
        String ferretPalDailyRation = ferret.calculatePalDailyRation();
        Assertions.assertEquals("50", ferretPalDailyRation);
    }
}
