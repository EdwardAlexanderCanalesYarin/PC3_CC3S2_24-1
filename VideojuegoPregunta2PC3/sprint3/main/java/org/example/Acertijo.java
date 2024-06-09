package org.example;

public class Acertijo {
    String pregunta;
    String respuesta;
    public Acertijo(String pregunta, String respuesta){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
    public boolean resolvioAcertijo(String respuestaJugador) {
        if(respuesta.equals(respuestaJugador)){
            return true;
        }
        return false;
    }
    public String getPregunta(){
        return pregunta;
    }
}