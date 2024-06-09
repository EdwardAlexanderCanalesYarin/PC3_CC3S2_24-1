import org.example.Acertijo;
import org.example.Juego;
import org.example.Jugador;
import org.example.Objeto;
import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class JuegoTest {
    // SPRINT 1 TESTS
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
    // SPRINT 2 TESTS
    // Test recoger objetos
    @Test
    public void recogerObjetoLlaveTest(){
        // Arrange
        Jugador jugador = new Jugador();
        Objeto objeto = new Objeto();
        objeto.setNombre("llave");
        // Act
        String resultado = jugador.recogerObjeto(objeto);
        // Assert
        assertEquals("Has recogido la llave", resultado, "Deberia mostrar que recogio la llave");
    }
    @Test
    public void recogerObjetoPocionTest(){
        // Arrange
        Jugador jugador = new Jugador();
        Objeto objeto = new Objeto();
        objeto.setNombre("pocion");
        // Act
        String resultado = jugador.recogerObjeto(objeto);
        // Assert
        assertEquals("Has recogido la pocion", resultado, "Deberia mostrar que recogio la pocion");
    }
    // Test gestion de inventario
    @Test
    public void agregarObjetosAlInventarioTest(){
        // Arrange
        Jugador jugador = new Jugador();
        Objeto objeto1 = new Objeto();
        Objeto objeto2 = new Objeto();
        objeto1.setNombre("llave");
        jugador.recogerObjeto(objeto1);
        objeto2.setNombre("pocion");
        jugador.recogerObjeto(objeto2);
        // Act
        boolean resultado1 = jugador.getObjeto(objeto1);
        boolean resultado2 = jugador.getObjeto(objeto2);
        // Assert
        assertEquals(true, resultado1, "Deberia devolver true");
        assertEquals(true, resultado2, "Deberia devolver true");
    }
    // Test mecanica de resolucion de acertijos
    @Test
    public void acertijoResueltoTest(){
        // Arrange
        String pregunta = "¿Qué tiene un ojo pero no puede ver?";
        String respuesta = "ahuja";
        Acertijo acertijo = new Acertijo(pregunta, respuesta);
        String respuesta_jugador = "ahuja";
        // Act
        boolean resultado = acertijo.resolvioAcertijo(respuesta_jugador);
        // Assert
        assertEquals(true, resultado, "Deberia devolver true");
    }
    @Test
    public void acertijoNoResueltoTest(){
        // Arrange
        String pregunta = "¿Qué tiene un ojo pero no puede ver?";
        String respuesta = "ahuja";
        Acertijo acertijo = new Acertijo(pregunta, respuesta);
        String respuesta_jugador = "pulpo";
        // Act
        boolean resultado = acertijo.resolvioAcertijo(respuesta_jugador);
        // Assert
        assertEquals(false, resultado, "Deberia devolver false");
    }
}