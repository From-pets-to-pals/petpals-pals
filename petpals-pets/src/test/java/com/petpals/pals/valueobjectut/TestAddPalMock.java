package com.petpals.pals.valueobjectut;

import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.use_case.pal.AddPal;
import com.petpals.pals.domain.model.pal.Pal;
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
public class TestAddPalMock {
    @Mock
    private Pals pals;

    @InjectMocks
    private AddPal palService;

    @Test
    public void testSave(){
        var toReturn = Pal.builder().name("Ash").build();
        when(pals.savePal(any(Pal.class))).thenReturn(toReturn);
        var savedPal = palService.savePalToInMemoryDb(toReturn);
        verifyNoMoreInteractions(pals);
        Assertions.assertEquals(savedPal.getName(), "Ash");
    }
}
