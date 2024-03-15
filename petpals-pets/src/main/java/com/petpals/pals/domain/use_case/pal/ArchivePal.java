package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.model.pal.Pal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivePal {
    @Autowired
    private Pals pals;

    public Pal archivePalToInMemoryDb(Pal pal){
        return pals.archivePal(pal);
    }

}
