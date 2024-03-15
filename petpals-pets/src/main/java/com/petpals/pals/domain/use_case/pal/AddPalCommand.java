package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.model.pal.Pal;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddPalCommand {
    @Autowired
    private Pals pals;

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;


    public Pal savePalToInMemoryDb(Pal pal) {
        try{
            Set<ConstraintViolation<Pal>> violations = validator.validate( pal );
            System.out.println(violations);
        } catch (ConstraintViolationException palValidationException){
            throw new PalValidationException();
        }
        return pals.savePal(pal);
    }

}
