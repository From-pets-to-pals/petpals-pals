package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.model.pal.Pal;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddPalCommand {
    private final Pals pals;

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;

    @Autowired
    public AddPalCommand(Pals pals){
        this.pals = pals;
    }

    public Pal savePalToInMemoryDb(Pal pal) throws PalValidationException {
        Set<ConstraintViolation<Pal>> violations = validator.validate(pal);
        if(!violations.isEmpty()){
            throw new PalValidationException();
        }
        return pals.savePal(pal);
    }

}
