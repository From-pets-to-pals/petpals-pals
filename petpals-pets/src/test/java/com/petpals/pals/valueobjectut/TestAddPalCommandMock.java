package com.petpals.pals.valueobjectut;

import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.use_case.pal.AddPalCommand;
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
    public void testSave() throws Exception {
        var toReturn = Pal.builder().name("Ash").birthDate(Date.valueOf(LocalDate.now())).build();
        when(pals.savePal(any(Pal.class))).thenReturn(toReturn);
        var savedPal = palService.savePalToInMemoryDb(toReturn);
        verifyNoMoreInteractions(pals);
        Assertions.assertEquals(savedPal.getName(), "Ash");
    }

    @Test
    public void testSaveFailValidation() {
        var toReturn = Pal.builder().name("Ash").build();
        ThrowableAssert.ThrowingCallable savedPal =
                () -> palService.savePalToInMemoryDb(toReturn);

        assertThatExceptionOfType(Exception.class).isThrownBy(savedPal);
    }
}
