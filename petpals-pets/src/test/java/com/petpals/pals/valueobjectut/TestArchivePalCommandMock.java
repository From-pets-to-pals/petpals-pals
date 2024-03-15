package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.model.pal.PalIdentityInformation;
import com.petpals.pals.domain.model.pal.PalMeasurement;
import com.petpals.pals.domain.model.pal.Species;
import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.use_case.pal.ArchivePalCommand;
import com.petpals.pals.domain.model.pal.Pal;
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
public class TestArchivePalCommandMock {
    @Mock
    private Pals pals;

    @InjectMocks
    private ArchivePalCommand palService;

    @Test
    public void testArchive() throws Exception {
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true, Species.DOG,"Husky","2562200000000", true);
        Pal doggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();

        Pal deadDoggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).hasDied(true).build();


        when(pals.archivePal(any(Pal.class))).thenReturn(deadDoggo);

        var savedPal = palService.archivePalToInMemoryDb(doggo);
        verifyNoMoreInteractions(pals);

        Assertions.assertTrue(savedPal.isHasDied());

    }

    @Test
    public void testArchiveFailValidation() {
        PalMeasurement palMeasurement = new PalMeasurement(20.0, 50.0);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation("Ash", Date.valueOf(LocalDate.of(2023, 02, 20)),true, Species.DOG,"Husky","2562200000000", true);
        Pal doggo = Pal.builder().palIdentityInformation(palIdentityInformation).palMeasurement(palMeasurement).build();

        ThrowableAssert.ThrowingCallable archivedPal =
                () -> palService.archivePalToInMemoryDb(doggo);

        assertThatExceptionOfType(Exception.class).isThrownBy(archivedPal);
    }
}
