package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    List<Objeto> inventario = new ArrayList<>();
    int score = 0;
    public String moverHacia(String direccion) {
        return "Te mueves al " + direccion;
    }
    public String recogerObjeto(Objeto objeto) {
        inventario.add(objeto);
        return "Has recogido la " + objeto.getNombre();
    }

    public boolean getObjeto(Objeto objeto) {
        return inventario.contains(objeto);
    }

    public boolean encontroObjetivoFinal(String objetivo_final) {
        for(Objeto obj: inventario){
            if(obj.getNombre().equals(objetivo_final)){
                return true;
            }
        }
        return false;
    }
    public void resolverAcertijo(Acertijo acertijo, String respuestaJugador) {
        if(acertijo.resolvioAcertijo(respuestaJugador)){
            score += 1;
        }
    }
    public boolean completoMisionPrincipal() {
        if(score == 3){
            return true;
        }
        return false;
    }
    public int getScore(){
        return score;
    }
}