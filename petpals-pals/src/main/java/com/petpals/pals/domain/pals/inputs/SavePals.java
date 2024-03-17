package com.petpals.pals.domain.pals.inputs;

import com.petpals.pals.domain.pals.services.SavePalsService;

public class SavePals implements SavePalsService {
    @Override
    public String SavePal(String palName) {
        return "Hello world, and " + palName;
    }
}
