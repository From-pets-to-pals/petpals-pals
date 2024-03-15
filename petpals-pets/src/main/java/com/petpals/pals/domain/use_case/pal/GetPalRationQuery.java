package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.domain.model.pal.Pal;

public class GetPalRationQuery {
    public String getPalRation(Pal pal){
        return pal.calculatePalDailyRation();
    }
}
