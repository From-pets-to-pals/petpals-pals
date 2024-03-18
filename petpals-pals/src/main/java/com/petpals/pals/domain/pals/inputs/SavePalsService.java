package com.petpals.pals.domain.pals.inputs;

import com.petpals.pals.domain.pals.model.Pals;

public interface SavePalsService {
    Pals SavePal(Pals palName);
    String helloPal(String pal);
}
