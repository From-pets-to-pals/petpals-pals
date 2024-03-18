package com.petpals.pals.domain.pals.utils.uuid;

import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class UUIDFormatter {
    private static final Logger LOGGER = LoggerFactory.getLogger(UUIDFormatter.class.getName());
    public static String formatUUIDSequence(UUID uuidToFormat, boolean withUnionTrailRemoval,@NotNull String joiner){
        if(uuidToFormat == null){
            throw new IllegalArgumentException("UUID can not be null");
        }
        LOGGER.info(
                "Formatting UUIDSequence. UUID : ".concat(uuidToFormat.toString()).concat(" SplitOption : ").concat(withUnionTrailRemoval ? "true":"false").concat(" Joiner : ").concat(joiner.toString()));
        return String.join(joiner, uuidToFormat.toString().split("-"));
    }
}
