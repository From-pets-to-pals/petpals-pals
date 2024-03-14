package com.petpals.pals.valueobjectut;

import com.petpals.pals.demo.FakeRepo;
import com.petpals.pals.domain.use_case.pal.AddPal;
import com.petpals.pals.model.pal.Pal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestMock {
    @Mock
    private FakeRepo fakeRepo;

    @InjectMocks
    private AddPal palService;

    @Test
    public void testThisShit(){
        var toReturn = Pal.builder().name("Ash").build();
        Mockito.when(fakeRepo.savePal(any(Pal.class))).thenReturn(toReturn);
        var savedPal = palService.savePalToInMemoryDb();
        Assertions.assertEquals(savedPal.getName(), "Ash");
    }
}
