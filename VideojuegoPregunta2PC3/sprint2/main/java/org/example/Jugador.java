package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    List<Objeto> inventario = new ArrayList<>();
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
}