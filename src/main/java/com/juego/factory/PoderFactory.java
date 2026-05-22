package com.juego.factory;

import com.juego.strategy.Poder;

public class PoderFactory {
    public static Poder crearPoder(String tipoPersonaje, int opcion) {
        if (tipoPersonaje.equalsIgnoreCase("Goku")) {
            switch (opcion) {
                case 1: return new com.juego.strategy.PunoDragon();
                case 2: return new com.juego.strategy.KameHameHa();
                default: return new com.juego.strategy.KameHameHa();
            }
        } else if (tipoPersonaje.equalsIgnoreCase("Vegeta")) {
            switch (opcion) {
                case 1: return new com.juego.strategy.BigBangAttack();
                case 2: return new com.juego.strategy.FinalFlash();
                default: return new com.juego.strategy.BigBangAttack();
            }
        }
        return null;
    }
}
