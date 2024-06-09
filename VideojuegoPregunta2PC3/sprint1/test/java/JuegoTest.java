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