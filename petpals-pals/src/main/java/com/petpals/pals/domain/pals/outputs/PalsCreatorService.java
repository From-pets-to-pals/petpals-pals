package com.petpals.pals.domain.pals.outputs;

import com.petpals.pals.domain.pals.model.Pals;

public interface PalsCreatorService {
    Long createPalWithOwner(Pals palWithOwner);
}
