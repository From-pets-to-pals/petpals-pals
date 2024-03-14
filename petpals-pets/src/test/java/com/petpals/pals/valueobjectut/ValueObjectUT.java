package com.petpals.pals.valueobjectut;

import com.petpals.pals.model.pal.Pals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class ValueObjectUT {

    @Test
    public void checkValueObjectHashCode(){
        LocalDate localDate = LocalDate.of(2014, 9, 11);
        Date date = Date.valueOf(localDate);
        Pals pal1 = new Pals(
                "Ash",
                date,
                "Dog",
                "Husky",
                1L,
                "ABC",
                true,
                true,
                18.0,
                60.0,
                "XCF123",
                new ArrayList<>(),
                null,
                null,
                true,
                true
        );
        Pals pal2 = new Pals(
                "Ash",
                date,
                "Dog",
                "Husky",
                1L,
                "ABC",
                true,
                true,
                18.0,
                60.0,
                "XCF123",
                new ArrayList<>(),
                null,
                null,
                true,
                true
        );
        Assertions.assertEquals(pal1, pal2);
    }
}
