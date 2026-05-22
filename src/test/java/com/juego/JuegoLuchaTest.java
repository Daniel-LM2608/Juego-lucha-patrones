package com.juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import com.juego.model.Personaje;
import com.juego.model.Goku;
import com.juego.model.Vegeta;
import com.juego.model.JuegoLucha;
import com.juego.factory.PersonajeFactory;
import com.juego.factory.PoderFactory;
import com.juego.strategy.Poder;

public class JuegoLuchaTest {

    @Test
    public void testCreacionPersonajesFactory() {
        Personaje goku = PersonajeFactory.crearPersonaje(1, "Kakaroto");
        Personaje vegeta = PersonajeFactory.crearPersonaje(2, "Príncipe");
        Personaje defecto = PersonajeFactory.crearPersonaje(99, "Invalido");

        assertEquals("Kakaroto", goku.getNombre());
        assertTrue(goku instanceof Goku);
        assertTrue(vegeta instanceof Vegeta);
        assertTrue(defecto instanceof Goku); // Por defecto retorna Goku
    }

    @Test
    public void testCreacionPoderesFactory() {
        Poder gokuPoder = PoderFactory.crearPoder("Goku", 1); // Puño dragón
        Poder vegetaPoder = PoderFactory.crearPoder("Vegeta", 2); // Final Flash
        Poder defectoPoder = PoderFactory.crearPoder("Goku", 45);

        assertNotNull(gokuPoder);
        assertEquals("Puño del Dragón", gokuPoder.getNombre());
        assertEquals("Final Flash", vegetaPoder.getNombre());
        assertEquals("Kame Hame Ha", defectoPoder.getNombre());
    }

    @Test
    public void testRecibirDanoYDefensa() {
        Personaje goku = PersonajeFactory.crearPersonaje(1, "GokuTest");
        int vidaInicial = goku.getPuntosDeVida();
        
        // Goku tiene 28 de resistencia. Si recibe 38 de daño, debe perder exactamente 10 de vida.
        goku.recibirDano(38);
        assertEquals(vidaInicial - 10, goku.getPuntosDeVida());
    }

    @Test
    public void testAtaqueGokuSimulado() {
        Personaje goku = PersonajeFactory.crearPersonaje(1, "Goku");
        Personaje vegeta = PersonajeFactory.crearPersonaje(2, "Vegeta");

        // Simulamos que el usuario digita "1" en la consola para elegir el Puño del Dragón
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        Scanner scannerSimulado = new Scanner(in);

        int vidaAntes = vegeta.getPuntosDeVida();
        goku.atacar(vegeta, scannerSimulado);

        assertTrue(vegeta.getPuntosDeVida() < vidaAntes || !vegeta.estaVivo());
    }

    @Test
    public void testAtaqueVegetaSimulado() {
        Personaje goku = PersonajeFactory.crearPersonaje(1, "Goku");
        Personaje vegeta = PersonajeFactory.crearPersonaje(2, "Vegeta");

        // Simulamos que el usuario digita "2" en la consola para elegir el Final Flash
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        Scanner scannerSimulado = new Scanner(in);

        int vidaAntes = goku.getPuntosDeVida();
        vegeta.atacar(goku, scannerSimulado);

        assertTrue(goku.getPuntosDeVida() < vidaAntes || !goku.estaVivo());
    }

    @Test
    public void testSimulacionPeleaCompleta() {
        Personaje goku = PersonajeFactory.crearPersonaje(1, "Goku");
        Personaje vegeta = PersonajeFactory.crearPersonaje(2, "Vegeta");

        // Una ráfaga de ataques simulados (1 y 2 repetidamente) para asegurar que la pelea termine rápido
        String entradasSimuladas = "1\n2\n1\n2\n1\n2\n1\n2\n1\n2\n1\n2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(entradasSimuladas.getBytes());
        Scanner scannerSimulado = new Scanner(in);

        JuegoLucha juego = new JuegoLucha(goku, vegeta, scannerSimulado);
        juego.iniciarPelea();

        // Al menos uno de los dos debió caer en combate
        assertTrue(!goku.estaVivo() || !vegeta.estaVivo());
    }
}
