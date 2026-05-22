package com.juego.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {
    private Personaje guerrero;

    @BeforeEach
    void setup() {
        guerrero = new Personaje("Thor");
    }

    @Test
    @DisplayName("Debe crear personaje con 100 HP")
    void testCreacionPersonaje() {
        assertEquals("Thor", guerrero.getNombre());
        assertEquals(100, guerrero.getPuntosDeVida());
        assertTrue(guerrero.estaVivo());
    }

    @Test
    @DisplayName("Debe reducir HP al recibir danio")
    void testRecibirDano() {
        guerrero.recibirDano(30);
        assertEquals(70, guerrero.getPuntosDeVida());
    }

    @Test
    @DisplayName("HP no debe ser negativo")
    void testHpNoNegativo() {
        guerrero.recibirDano(150);
        assertEquals(0, guerrero.getPuntosDeVida());
        assertFalse(guerrero.estaVivo());
    }

    @Test
    @DisplayName("Ataque debe causar danio entre 10 y 30")
    void testRangoAtaque() {
        Personaje oponente = new Personaje("Loki");
        int vidaInicial = oponente.getPuntosDeVida();
        guerrero.atacar(oponente);
        int vidaFinal = oponente.getPuntosDeVida();
        int dano = vidaInicial - vidaFinal;
        assertTrue(dano >= 10 && dano <= 30, "El danio debe estar entre 10 y 30, fue: " + dano);
    }
}
