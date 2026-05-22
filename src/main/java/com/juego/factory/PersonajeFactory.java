package com.juego.factory;

import com.juego.model.Personaje;
import com.juego.model.Goku;
import com.juego.model.Vegeta;

public class PersonajeFactory {
    public static Personaje crearPersonaje(int opcion, String nombreJugador) {
        switch (opcion) {
            case 1: return new Goku(nombreJugador);
            case 2: return new Vegeta(nombreJugador);
            default:
                System.out.println("Opción inválida. Se seleccionará Goku por defecto.");
                return new Goku(nombreJugador);
        }
    }
}
