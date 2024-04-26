package com.petpals.bootstrap

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
object Pals {
    @JvmStatic
    fun main(args: Array<String>) {
        Quarkus.run(*args)
    }
}