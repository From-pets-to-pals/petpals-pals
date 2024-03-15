package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.model.pal.PalIdentityInformation;
import com.petpals.pals.domain.model.pal.PalMeasurement;
import com.petpals.pals.domain.model.pal.Species;
import com.petpals.pals.domain.use_case.pal.AddPalCommand;
import com.petpals.pals.domain.use_case.pal.PalValidationException;
import com.petpals.pals.domain.use_case.pal.UpdatePalCommand;
import com.petpals.pals.domain.model.pal.Pal;
import com.petpals.pals.repository.Pals;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestUpdatePalMock {
    @Mock
    private Pals palsRepo;

    @InjectMocks
    private AddPalCommand addPalService;

    @InjectMocks
    private UpdatePalCommand updatePalService;

    @Test
    public void testUpdate() throws Exception, PalValidationException {
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true, Species.DOG,"Husky","2562200000000", true);
        Pal doggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();

        palIdentityInformation = new PalIdentityInformation("Ashhhhh", Date.valueOf(LocalDate.of(2023, 02, 20)),true, Species.DOG,"Husky","2562200000000", true);
        Pal modifiedDoggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();

        when(palsRepo.savePal(any(Pal.class))).thenReturn(doggo);
        when(palsRepo.updatePal(any(Pal.class))).thenReturn(modifiedDoggo);

        var toModify = addPalService.savePalToInMemoryDb(doggo);

        var updatedPal = updatePalService.updatePalToInMemoryDb(toModify);
        verifyNoMoreInteractions(palsRepo);

        Assertions.assertEquals(updatedPal.getPalIdentityInformation().name(), "Ashhhhh");

    }

    @Test
    public void testArchiveFailValidation() {
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true, Species.DOG,"Husky","2562200000000", true);
        Pal doggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();

        ThrowableAssert.ThrowingCallable updatedPal =
                () -> updatePalService.updatePalToInMemoryDb(doggo);

        assertThatExceptionOfType(Exception.class).isThrownBy(updatedPal);
    }
}
