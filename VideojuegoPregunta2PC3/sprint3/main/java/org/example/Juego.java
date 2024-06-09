package org.example;

import java.util.Scanner;

public class Juego {
    Habitacion habitacion_actual;
    Habitacion[] habitaciones;
    String objetivo_final;
    String mision_principal;
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
    public void setObjetivoFinal(String objetivo_final) {
        this.objetivo_final = objetivo_final;
    }
    public String getObjetivoFinal(){
        return objetivo_final;
    }
    public void setMisionPrincipal(String mision_principal) {
        this.mision_principal = mision_principal;
    }
    public String getMision_principal(){
        return mision_principal;
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
        juego.setObjetivoFinal("llave dorada");
        juego.setMisionPrincipal("Resolver 3 acertijos");
        Acertijo[] acertijos = new Acertijo[3];
        acertijos[0] = new Acertijo("¿Qué tiene un ojo pero no puede ver?", "ahuja");
        acertijos[1] = new Acertijo("¿Qué se moja mientras seca?", "toalla");
        acertijos[2] = new Acertijo("Soy alto cuando soy joven, y soy bajo cuando soy viejo. ¿Qué soy?", "vela");
        System.out.println("PARA GANAR DEBES: ");
        System.out.println("Conseguir el objetivo final: " + juego.getObjetivoFinal());
        System.out.println("o");
        System.out.println("Completar la mision principal: " + juego.getMision_principal());
        String entrada, movimiento, respuesta_jugador;
        int iteraciones = 0;
        while(!(jugador.encontroObjetivoFinal(juego.getObjetivoFinal())) && !(jugador.completoMisionPrincipal())){
            System.out.println("Puedes moverte hacia los puntos cardinales");
            movimiento = scanner.nextLine().toLowerCase();
            System.out.println(jugador.moverHacia(movimiento));
            System.out.println("Ves una llave en el suelo");
            entrada = scanner.nextLine().toLowerCase();
            if(entrada.contains("recoger")){
                String[] palabras = entrada.split(" ");
                Objeto obj = new Objeto();
                obj.setNombre(palabras[palabras.length - 1]);
                System.out.println(jugador.recogerObjeto(obj));
            }
            System.out.println("La siguiente habitacion esta noreste");
            movimiento = scanner.nextLine().toLowerCase();
            System.out.println(jugador.moverHacia(movimiento));
            movimiento = scanner.nextLine().toLowerCase();
            System.out.println(jugador.moverHacia(movimiento));
            System.out.println("Resuelve el siguiente acertijo: ");
            System.out.println(acertijos[jugador.getScore()].getPregunta());
            respuesta_jugador = scanner.nextLine().toLowerCase();
            jugador.resolverAcertijo(acertijos[jugador.getScore()], respuesta_jugador);
            if(acertijos[jugador.getScore()-1].resolvioAcertijo(respuesta_jugador)){
                System.out.println("RESPUESTA CORRECTA");
            }else{
                System.out.println("RESPUESTA INCORRECTA");
            }
            if(iteraciones == 4){
                System.out.println("Encontraste la llave dorada, recogela");
                Objeto obj = new Objeto();
                obj.setNombre("llave dorada");
                System.out.println(jugador.recogerObjeto(obj));
            }
            iteraciones += 1;
        }
        System.out.println("GANASTE, TERMINO EL JUEGO");
    }
}