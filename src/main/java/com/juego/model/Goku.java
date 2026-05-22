package com.juego.model;

import java.util.Scanner;
import com.juego.strategy.Poder;
import com.juego.factory.PoderFactory;

public class Goku extends Personaje {
    private static final int FUERZA = 5;
    private static final int RESISTENCIA = 28;

    public Goku(String nombre) { super(nombre, RESISTENCIA); }

    @Override
    public void atacar(Personaje oponente, Scanner scanner) {
        System.out.println("\n--- TURNO DE " + getNombre().toUpperCase() + " ---");
        System.out.println("Elige un poder:\n1. Puño del Dragón (daño x10)\n2. Kame Hame Ha (daño x4)");
        System.out.print("Ingresa el número de la opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        Poder poderElegido = PoderFactory.crearPoder(this.getClass().getSimpleName(), opcion);
        int danoBase = calcularDanoBase();
        int danoTotal = poderElegido.usarPoder(danoBase, FUERZA); 

        System.out.println(getNombre() + " realiza ¡" + poderElegido.getNombre() + "!");
        oponente.recibirDano(danoTotal);
    }
}
