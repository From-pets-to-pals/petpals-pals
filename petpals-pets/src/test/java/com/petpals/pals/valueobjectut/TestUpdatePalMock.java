package com.petpals.pals.valueobjectut;

import com.petpals.pals.demo.FakeRepo;
import com.petpals.pals.domain.use_case.pal.AddPal;
import com.petpals.pals.domain.use_case.pal.ArchivePal;
import com.petpals.pals.domain.use_case.pal.UpdatePal;
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
public class TestUpdatePalMock {
    @Mock
    private FakeRepo fakeRepo;

    @InjectMocks
    private AddPal addPalService;

    @InjectMocks
    private UpdatePal updatePalService;

    @Test
    public void testUpdate(){
        var toReturn = Pal.builder().name("Ashhhhh").build();
        var toSave = Pal.builder().name("Ash").build();

        Assertions.assertEquals(toSave.getName(), "Ash");
        when(fakeRepo.savePal(any(Pal.class))).thenReturn(toReturn);
        var toModify = addPalService.savePalToInMemoryDb(toSave);

        when(fakeRepo.updatePal(any(Pal.class))).thenReturn(toReturn);

        var updatedPal = updatePalService.updatePalToInMemoryDb(toModify);
        verifyNoMoreInteractions(fakeRepo);

        Assertions.assertEquals(updatedPal.getName(), "Ashhhhh");

    }
}
