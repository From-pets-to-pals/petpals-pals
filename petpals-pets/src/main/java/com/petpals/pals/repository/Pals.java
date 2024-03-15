package com.petpals.pals.repository;

import com.petpals.pals.domain.model.pal.Pal;

public interface Pals {

    Pal savePal(Pal pal);

    Pal archivePal(Pal pal);

    Pal updatePal(Pal pal);
}
