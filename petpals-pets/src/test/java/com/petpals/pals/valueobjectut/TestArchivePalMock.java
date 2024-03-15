package com.petpals.pals.valueobjectut;

import com.petpals.pals.demo.FakeRepo;
import com.petpals.pals.domain.use_case.pal.AddPal;
import com.petpals.pals.domain.use_case.pal.ArchivePal;
import com.petpals.pals.model.pal.Pal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestArchivePalMock {
    @Mock
    private FakeRepo fakeRepo;

    @InjectMocks
    private ArchivePal palService;

    @Test
    public void testArchive(){
        var toReturn = Pal.builder().name("Doggi").hasDied(true).build();
        var toArchive = Pal.builder().name("Doggi").build();

        Assertions.assertEquals(toReturn.getName(), "Doggi");

        when(fakeRepo.archivePal(any(Pal.class))).thenReturn(toReturn);

        var savedPal = palService.archivePalToInMemoryDb(toArchive);
        verifyNoMoreInteractions(fakeRepo);

        Assertions.assertEquals(savedPal.getName(), "Doggi");
        Assertions.assertTrue(savedPal.isHasDied());

    }
}
