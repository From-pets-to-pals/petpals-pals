package com.petpals.pals.domain.pals.inputs;

import com.petpals.pals.entrypoints.pals.dto.AddPal;

public interface SavePalsService {
    String SavePal(AddPal palName);
    String helloPal(String pal);
}
