package com.juego;

import java.util.Scanner;
import com.juego.model.Personaje;
import com.juego.model.JuegoLucha;
import com.juego.factory.PersonajeFactory;

public class MainLucha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.println("Elige un personaje para " + nombre1 + ":\n1. Goku\n2. Vegeta");
        System.out.print("Opción: ");
        int opcion1 = scanner.nextInt();
        scanner.nextLine(); 

        Personaje jugador1 = PersonajeFactory.crearPersonaje(opcion1, nombre1);

        System.out.print("\nIntroduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.println("Elige un personaje para " + nombre2 + ":\n1. Goku\n2. Vegeta");
        System.out.print("Opción: ");
        int opcion2 = scanner.nextInt();
        scanner.nextLine(); 

        Personaje jugador2 = PersonajeFactory.crearPersonaje(opcion2, nombre2);

        JuegoLucha juego = new JuegoLucha(jugador1, jugador2, scanner);
        juego.iniciarPelea();

        scanner.close(); 
    }
}
