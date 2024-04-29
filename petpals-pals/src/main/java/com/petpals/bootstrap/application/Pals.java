package com.petpals.bootstrap.application;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;



@QuarkusMain
public class Pals {
    public static void main(String ... args) {
        Quarkus.run(args);
    }
}
