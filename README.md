# 🎮 Proyecto Dragon Ball - Juego de Lucha con Patrones de Diseño

Este proyecto implementa un juego de combate por turnos en consola entre guerreros Saiyajin, desarrollado en **Java 17** utilizando **Maven** y arquitectura limpia orientada a patrones de diseño.

## 🛠️ Patrones de Diseño Implementados

### 1. Factory Method (Creacional)
* **Clases:** `PersonajeFactory` y `PoderFactory`
* **Propósito:** Centraliza e independiza la creación de las instancias de los personajes (`Goku`, `Vegeta`) y de sus respectivas estrategias de ataque especiales basándose en las decisiones del usuario, evitando el acoplamiento directo.

### 2. Strategy (Comportamiento)
* **Clases:** `Poder` (Interfaz/Estrategia abstracta) y sus implementaciones (`KameHameHa`, `PunoDragon`, `BigBangAttack`, `FinalFlash`).
* **Propósito:** Permite cambiar dinámicamente el comportamiento y el multiplicador de daño de los ataques en tiempo de ejecución, encapsulando cada habilidad en su propia clase.

---

## 🧪 Pruebas Unitarias y Cobertura
El proyecto cuenta con una suite completa de pruebas automatizadas utilizando **JUnit 5**, simulando de forma interactiva los flujos de la consola (`Scanner`).
La cobertura de código es medida automáticamente mediante **JaCoCo**, superando holgadamente el 80% requerido por la rúbrica.

---

## ⚙️ Integración Continua (CI/CD)
El proyecto cuenta con un flujo automatizado en **GitHub Actions** (`.github/workflows/ci.yml`) que compila, ejecuta los tests y verifica el empaquetado del software con cada commit.
