package com.juego.model;

import java.util.Random;
import java.util.Scanner;

public abstract class Personaje {
    private String nombre;
    private int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;
    private int defensa; 

    public Personaje(String nombre, int defensa) {
        this.nombre = nombre;
        this.puntosDeVida = 100; 
        this.defensa = defensa;
    }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    protected int calcularDanoBase() {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        System.out.println("Daño base generado: " + dano);
        return dano;
    }

    public abstract void atacar(Personaje oponente, Scanner scanner);

    public void recibirDano(int dano) {
        int danoReducido = Math.max(0, dano - this.defensa);
        this.puntosDeVida = Math.max(0, this.puntosDeVida - danoReducido);

        System.out.println(this.nombre + " recibe " + danoReducido + " puntos de daño tras aplicar su defensa de " + this.defensa);

        if (this.puntosDeVida == 0) {
            System.out.println(this.nombre + " ha sido derrotado.");
        }
    }

    public boolean estaVivo() { return this.puntosDeVida > 0; }
    public String getNombre() { return this.nombre; }
    public int getPuntosDeVida() { return this.puntosDeVida; }

    @Override
    public String toString() {
        return nombre + " (HP: " + puntosDeVida + ", DEF: " + defensa + ")";
    }
}
