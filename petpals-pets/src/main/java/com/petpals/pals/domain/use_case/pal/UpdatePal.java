package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.demo.FakeRepo;
import com.petpals.pals.model.pal.Pal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePal {

    @Autowired
    private FakeRepo fakeRepo;

    public Pal updatePalToInMemoryDb(Pal pal){
        return fakeRepo.updatePal(pal);
    }
}
