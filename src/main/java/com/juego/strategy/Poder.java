package com.juego.strategy;

public abstract class Poder {
    private String nombre;
    private int multiplicador;

    public Poder(String nombre, int multiplicador) {
        this.nombre = nombre;
        this.multiplicador = multiplicador;
    }

    public String getNombre() {
        return nombre;
    }

    public int usarPoder(int danoBase, int fuerzaPersonaje) {
        int danoTotal = danoBase + fuerzaPersonaje;
        return danoTotal * this.multiplicador;
    }
}
