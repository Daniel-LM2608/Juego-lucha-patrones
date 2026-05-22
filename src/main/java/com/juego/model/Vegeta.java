package com.juego.model;

import java.util.Scanner;
import com.juego.strategy.Poder;
import com.juego.factory.PoderFactory;

public class Vegeta extends Personaje {
    private static final int FUERZA = 7;
    private static final int RESISTENCIA = 25;

    public Vegeta(String nombre) { super(nombre, RESISTENCIA); }

    @Override
    public void atacar(Personaje oponente, Scanner scanner) {
        System.out.println("\n--- TURNO DE " + getNombre().toUpperCase() + " ---");
        System.out.println("Elige un poder:\n1. Big Bang Attack (daño x3)\n2. Final Flash (daño x8)");
        System.out.print("Ingresa el número de la opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        Poder poderElegido = PoderFactory.crearPoder(this.getClass().getSimpleName(), opcion);
        int danoBase = calcularDanoBase();
        int danoTotal = poderElegido.usarPoder(danoBase, FUERZA);

        System.out.println(getNombre() + " ejecuta ¡" + poderElegido.getNombre() + "!");
        oponente.recibirDano(danoTotal);
    }
}
