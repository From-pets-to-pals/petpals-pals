package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.demo.FakeRepo;
import com.petpals.pals.domain.model.pal.Pal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivePal {
    @Autowired
    private FakeRepo fakeRepo;

    public Pal archivePalToInMemoryDb(Pal pal){
        return fakeRepo.archivePal(pal);
    }

}
