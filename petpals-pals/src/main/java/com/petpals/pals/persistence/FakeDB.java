package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.model.Pals;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;


public class FakeDB {
    private static HashMap<Long, Pals> palDb = new HashMap<>();
    private static long sequence = 1;

    public static Long addToDb(Pals pal){
        final var palId = getAvailableSequence();
        doPetExist(pal);
        palDb.put(palId, pal);
        incrementSequence();
        return palId;
    }

    private static void doPetExist(Pals pal) {
        AtomicBoolean doPetExist = new AtomicBoolean(false);
        palDb.forEach((k,v) -> {
            if(v.getPalIdentityInformation().icadIdentifier().contentEquals(pal.getPalIdentityInformation().icadIdentifier())){
                doPetExist.set(true);
            }
        });
        if(doPetExist.get()){
           throw new RuntimeException("pet exists") ;
        }
    }

    public static boolean doOwnerExist(String ownerMail) {
        AtomicBoolean doPetExist = new AtomicBoolean(false);
        palDb.forEach((k,v) -> {
            if(v.getOwner().email().contentEquals(ownerMail)){
                doPetExist.set(true);
            }
        });
        return doPetExist.get();
    }

    private static void incrementSequence(){
        sequence = sequence + 1;
    }

    private static long getAvailableSequence(){
        return sequence;
    }
}
