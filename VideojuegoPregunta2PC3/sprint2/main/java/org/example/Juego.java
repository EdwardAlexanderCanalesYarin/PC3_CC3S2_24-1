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
        System.out.println("Ves una llave en el suelo");
        String entrada = scanner.nextLine().toLowerCase();
        if(entrada.contains("recoger")){
            String[] palabras = entrada.split(" ");
            Objeto obj = new Objeto();
            obj.setNombre(palabras[palabras.length - 1]);
            System.out.println(jugador.recogerObjeto(obj));
        }

    }
}