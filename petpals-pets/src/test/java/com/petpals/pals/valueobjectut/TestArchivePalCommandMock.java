package com.petpals.pals.valueobjectut;

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
        var toReturn = Pal.builder().name("Doggi").hasDied(true).birthDate(Date.valueOf(LocalDate.now())).build();
        var toArchive = Pal.builder().name("Doggi").hasDied(false).birthDate(Date.valueOf(LocalDate.now())).build();

        Assertions.assertEquals(toArchive.getName(), "Doggi");
        Assertions.assertFalse(toArchive.isHasDied());

        when(pals.archivePal(any(Pal.class))).thenReturn(toReturn);

        var savedPal = palService.archivePalToInMemoryDb(toArchive);
        verifyNoMoreInteractions(pals);

        Assertions.assertEquals(savedPal.getName(), "Doggi");
        Assertions.assertTrue(savedPal.isHasDied());

    }

    @Test
    public void testArchiveFailValidation() {
        var toArchive = Pal.builder().name("Doggi").hasDied(false).build();

        ThrowableAssert.ThrowingCallable archivedPal =
                () -> palService.archivePalToInMemoryDb(toArchive);

        assertThatExceptionOfType(Exception.class).isThrownBy(archivedPal);
    }
}
