# PC3_CC3S2_24-1 - PREGUNTA 2
## SPRINT 1
### Clases a implementar:
* Juego: Clase principal para iniciar y controlar el flujo del juego.  
* Habitación: Representa una habitación en el juego.  
* Jugador: Representa al jugador y rastrea su inventario y ubicación actual.  
### Tareas:
1. Inicialización del juego: Inicializa el juego con un conjunto de habitaciones.o Define la habitación inicial para el jugador.  
2. Movimiento del jugador: Permite al jugador moverse entre habitaciones usando comandos.  
3. Interacción básica: Implementa comandos básicos para el movimiento (por ejemplo, "mover norte").  
### Enfoque TDD:
Escribe pruebas para la creación de habitaciones, movimiento del jugador e inicialización del juego.  
### Salida:
Navegación funcional entre habitaciones.  
Mostrar la descripción de la habitación actual al entrar.  

Creo los tests primero para seguir el enfoque TDD  
``` java
import org.example.Juego;
import org.example.Jugador;
import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class JuegoTest {
    // Tests para la creacion de habitaciones
    @Test
    public void CreacionDeHabitacionesConExitoTest(){
        // Arrange
        int n_habitaciones = 5;
        Juego juego = new Juego();
        // Act
        int n_habitaciones_creadas = juego.crearHabitaciones(n_habitaciones);
        // Assert
        assertEquals(5, n_habitaciones_creadas, "Deberia ser 5");
    }
    @Test
    public void CreacionDeHabitacionesSinExitoTest(){
        // Arrange
        int n_habitaciones = -2;
        Juego juego = new Juego();
        // Act y Assert
        assertThrows(IllegalArgumentException.class, ()->{
            juego.crearHabitaciones(n_habitaciones);
        });
    }

    // Tests para el movimiento del jugador
    @Test
    public void MovimientoDeJugadorHaciaElNorteTest(){
        // Arrange
        Jugador jugador = new Jugador();
        String direccion = "norte";
        // Act
        String resultado = jugador.moverHacia(direccion);
        // Assert
        assertEquals("Te mueves al norte", resultado, "Deberia moverse al norte");
    }
    @Test
    public void MovimientoDeJugadorHaciaElSurTest(){
        // Arrange
        Jugador jugador = new Jugador();
        String direccion = "sur";
        // Act
        String resultado = jugador.moverHacia(direccion);
        // Assert
        assertEquals("Te mueves al sur", resultado, "Deberia moverse al sur");
    }
    @Test
    public void MovimientoDeJugadorHaciaElOesteTest(){
        // Arrange
        Jugador jugador = new Jugador();
        String direccion = "oeste";
        // Act
        String resultado = jugador.moverHacia(direccion);
        // Assert
        assertEquals("Te mueves al oeste", resultado, "Deberia moverse al oeste");
    }
    @Test
    public void MovimientoDeJugadorHaciaElEsteTest(){
        // Arrange
        Jugador jugador = new Jugador();
        String direccion = "este";
        // Act
        String resultado = jugador.moverHacia(direccion);
        // Assert
        assertEquals("Te mueves al este", resultado, "Deberia moverse al este");
    }

    // Test para la inicializacion del juego
    @Test
    public void InicializacionDelJuegoTest(){
        // Arrange
        Juego juego = new Juego();
        int n_habitaciones = 5;
        juego.crearHabitaciones(n_habitaciones);
        int habitacion_inicial = 2;
        juego.setHabitacionActual(habitacion_inicial);
        // Act
        String resultado = juego.getHabitacionActual().descripcionHabitacion();
        // Assert
        assertEquals("Estas en la habitacion 2", resultado, "Deberia mostrar que esta en la habitacion 2");
    }
}
``` 
![Sprint1CapturaPruebasFallidas](Image/Sprint1CapturaPruebasFallidas.png)  
Como se observa en la imagen, los tests fallan debido a que aun las clases Juego, Habitacion y Juegor no han sido implementadas.  
Ahora, teniendo como base las pruebas escritas, escribo codigo suficimiente para hacer pasar los tests.  

``` java
package org.example;

import java.util.Scanner;

public class Juego {
    Habitacion habitacion_actual;
    Habitacion[] habitaciones;
    public int crearHabitaciones(int nHabitaciones) {
        if(nHabitaciones <= 0){
            throw new IllegalArgumentException("Cantidad invalida de habitaciones");
        }
        habitaciones = new Habitacion[nHabitaciones];
        for(int i = 0; i < nHabitaciones; i++){
            Habitacion h = new Habitacion();
            h.setNHabitacion(i + 1);
            habitaciones[i] = h;
        }
        return habitaciones.length;
    }
    public void setHabitacionActual(int habitacionInicial) {
        habitacion_actual = habitaciones[habitacionInicial-1];
    }
    public Habitacion getHabitacionActual(){
        return habitacion_actual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_habitaciones = 5;
        Juego juego = new Juego();
        Jugador jugador = new Jugador();
        juego.crearHabitaciones(num_habitaciones);
        int habitacion_actual = 2;
        juego.setHabitacionActual(habitacion_actual);
        System.out.println("Inicio del juego, existen " + num_habitaciones + " habitaciones");
        System.out.println(juego.getHabitacionActual().descripcionHabitacion());
        System.out.println("Puedes moverte hacia los puntos cardinales");
        String movimiento = scanner.nextLine().toLowerCase();
        System.out.println(jugador.moverHacia(movimiento));
    }
}
```
``` java
package org.example;

public class Habitacion {
    int n_habitacion;
    public void setNHabitacion(int numero_habitacion) {
        n_habitacion = numero_habitacion;
    }
    public String descripcionHabitacion(){
        return "Estas en la habitacion " + n_habitacion;
    }
}
```
``` java
package org.example;

public class Jugador {
    public String moverHacia(String direccion) {
        return "Te mueves al " + direccion;
    }
}
```
![Sprint1CapturaPruebasExitosas](Image/Sprint1CapturaPruebasExitosas.png)  
Como se observa en la imagen, los 7 tests pasaron exitosamente (estan color verde).  

Ejecucion de la clase principal, Juego  
![Sprint1CapturaEjecucionMain](Image/Sprint1CapturaEjecucionMain.png) 
Se observa que la salida es la esperada para este sprint 1, se muestra la habitacion inicial al iniciar el juego y el jugador puede moverse usando comandos (mover norte por ejemplo)

## SPRINT 2
