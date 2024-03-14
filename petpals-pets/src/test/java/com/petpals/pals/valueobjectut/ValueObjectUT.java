package com.petpals.pals.valueobjectut;

import com.petpals.pals.model.pal.PalValueObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ValueObjectUT {

    @Test
    public void checkValueObjectHashCode(){
        LocalDate localDate = LocalDate.of(2014, 9, 11);
        Date date = Date.valueOf(localDate);
        PalValueObject pal1 = new PalValueObject(
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
        PalValueObject pal2 = new PalValueObject(
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
