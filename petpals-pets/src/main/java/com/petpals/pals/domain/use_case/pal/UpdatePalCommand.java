package com.petpals.pals.domain.use_case.pal;

import com.petpals.pals.repository.Pals;
import com.petpals.pals.domain.model.pal.Pal;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UpdatePalCommand {

    @Autowired
    private Pals pals;

    public Pal updatePalToInMemoryDb(Pal pal) throws Exception {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pal>> violations = validator.validate( pal );
        System.out.println(violations);
        if(violations.size() > 0){
            throw new Exception();
        }
        return pals.updatePal(pal);
    }
}
