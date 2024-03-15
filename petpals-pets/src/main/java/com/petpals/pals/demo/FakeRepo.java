package com.petpals.pals.demo;

import com.petpals.pals.domain.model.pal.Pal;

public interface FakeRepo {

    Pal savePal(Pal pal);

    Pal archivePal(Pal pal);

    Pal updatePal(Pal pal);
}
