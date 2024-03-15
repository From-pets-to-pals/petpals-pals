package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.model.pal.Pal;
import com.petpals.pals.domain.model.pal.PalIdentityInformation;
import com.petpals.pals.domain.model.pal.PalMeasurement;
import com.petpals.pals.domain.model.pal.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class TestDailyRation {
    @Test
    public void testDogDailyRation(){
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true,Species.DOG,"Husky","2562200000000", true);
        Pal doggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();
        String doggoPalDailyRation = doggo.calculatePalDailyRation();
        Assertions.assertEquals("300 grammes", doggoPalDailyRation);
    }

    @Test
    public void testCatDailyRation(){
        PalMeasurement palMeasurement = new PalMeasurement(6.0, 30.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true,Species.CAT,"CHartreux","2562200000000", true);

        Pal catsu = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();
        String catsuDailyRation = catsu.calculatePalDailyRation();
        Assertions.assertEquals("240 grammes", catsuDailyRation);
    }


    @Test
    public void testFerretDailyRation(){
        PalMeasurement palMeasurement = new PalMeasurement(1.0, 30.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true,Species.FERRET,"unknown","2562200000000", true);

        Pal ferret = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();
        String ferretPalDailyRation = ferret.calculatePalDailyRation();
        Assertions.assertEquals("50 grammes", ferretPalDailyRation);
    }
}
