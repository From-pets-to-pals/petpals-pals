package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.model.pal.*;
import com.petpals.pals.domain.use_case.pal.PalValidationException;
import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.use_case.pal.AddPalCommand;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestAddPalCommandMock {
    @Mock
    private Pals pals;

    @InjectMocks
    private AddPalCommand palService;

    @Test
    public void testSave() throws PalValidationException {
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true, Species.DOG,"Husky","2562200000000", true);
        PalMedicalInformation palMedicalInformation = new PalMedicalInformation(true, new ArrayList<>(),Date.valueOf(LocalDate.of(2024,05, 20)),Date.valueOf(LocalDate.of(2024,05, 20)),false);
        Pal doggo = Pal.builder()
                .palIdentityInformation(palIdentityInformation)
                .palMeasurement(palMeasurement)
                .palMedicalInformation(palMedicalInformation)
                .hasDied(false)
                .owner(1L)
                .build();

        when(pals.savePal(any(Pal.class))).thenReturn(doggo);
        var savedPal = palService.savePalToInMemoryDb(doggo);
        verifyNoMoreInteractions(pals);
        Assertions.assertEquals(savedPal.getPalIdentityInformation().name(), "Ash");
    }

    @Test
    public void testSaveFailValidation() {
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        Pal doggo = Pal.builder()
                .palMeasurement(palMeasurement)
                .hasDied(false)
                .owner(1L)
                .build();

        ThrowableAssert.ThrowingCallable savedPal =
                () -> palService.savePalToInMemoryDb(doggo);

        assertThatExceptionOfType(PalValidationException.class).isThrownBy(savedPal);
    }
}
