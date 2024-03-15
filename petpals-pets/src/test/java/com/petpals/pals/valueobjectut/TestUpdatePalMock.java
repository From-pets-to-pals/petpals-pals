package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.use_case.pal.AddPalCommand;
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
    public void testUpdate() throws Exception {
        var toReturn = Pal.builder().name("Ashhhhh").birthDate(Date.valueOf(LocalDate.now())).build();
        var toSave = Pal.builder().name("Ash").birthDate(Date.valueOf(LocalDate.now())).build();

        Assertions.assertEquals(toSave.getName(), "Ash");
        when(palsRepo.savePal(any(Pal.class))).thenReturn(toReturn);
        var toModify = addPalService.savePalToInMemoryDb(toSave);

        when(palsRepo.updatePal(any(Pal.class))).thenReturn(toReturn);

        var updatedPal = updatePalService.updatePalToInMemoryDb(toModify);
        verifyNoMoreInteractions(palsRepo);

        Assertions.assertEquals(updatedPal.getName(), "Ashhhhh");

    }

    @Test
    public void testArchiveFailValidation() {
        var toUpdate = Pal.builder().name("Doggi").height(40d).build();

        ThrowableAssert.ThrowingCallable updatedPal =
                () -> updatePalService.updatePalToInMemoryDb(toUpdate);

        assertThatExceptionOfType(Exception.class).isThrownBy(updatedPal);
    }
}
