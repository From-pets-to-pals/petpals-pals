package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.demo.FakeRepo;
import com.petpals.pals.model.pal.Pal;
import com.petpals.pals.model.pal.PalValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddPal {
    @Autowired
    private FakeRepo fakeRepo;

    public Pal savePalToInMemoryDb(){
        Pal newPal = Pal.builder().name("Ash").build();
        return fakeRepo.savePal(newPal);
    }

}
