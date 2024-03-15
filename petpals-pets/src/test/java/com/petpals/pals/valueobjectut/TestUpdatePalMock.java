package com.petpals.pals.valueobjectut;

import com.petpals.pals.domain.use_case.pal.AddPal;
import com.petpals.pals.domain.use_case.pal.UpdatePal;
import com.petpals.pals.domain.model.pal.Pal;
import com.petpals.pals.repository.Pals;
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
    private Pals palsRepo;

    @InjectMocks
    private AddPal addPalService;

    @InjectMocks
    private UpdatePal updatePalService;

    @Test
    public void testUpdate(){
        var toReturn = Pal.builder().name("Ashhhhh").build();
        var toSave = Pal.builder().name("Ash").build();

        Assertions.assertEquals(toSave.getName(), "Ash");
        when(palsRepo.savePal(any(Pal.class))).thenReturn(toReturn);
        var toModify = addPalService.savePalToInMemoryDb(toSave);

        when(palsRepo.updatePal(any(Pal.class))).thenReturn(toReturn);

        var updatedPal = updatePalService.updatePalToInMemoryDb(toModify);
        verifyNoMoreInteractions(palsRepo);

        Assertions.assertEquals(updatedPal.getName(), "Ashhhhh");

    }
}
