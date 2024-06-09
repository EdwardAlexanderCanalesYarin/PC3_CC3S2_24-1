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