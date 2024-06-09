package org.example;

public class CalculoCaYCe {
    public static void main(String[] args) {
        /*
        Juego
        Habitacion
        Jugador
        Objeto
        Acertijo
        */
        // Ca = n_clases externas que utilizan la clase actual
        // Ce = n_clases externas utilizadas por la clase actual

        Module juego = new Module("Juego");
        Module habitacion = new Module("Habitacion");
        Module jugador = new Module("Jugador");
        Module objeto = new Module("Objeto");
        Module acertijo = new Module("Acertijo");

        juego.addDependency(habitacion);
        juego.addDependency(jugador);
        juego.addDependency(objeto);
        juego.addDependency(acertijo);

        jugador.addDependency(objeto);
        jugador.addDependency(acertijo);
        Module[] modules = {juego,habitacion,jugador,objeto,acertijo};
        System.out.println("ACOPLAMIENTO EFERENTE:");
        System.out.println("Ce de la clase Juego = " + modules[0].getDependencies().size());
        System.out.println("Ce de la clase Habitacion = " + modules[1].getDependencies().size());
        System.out.println("Ce de la clase Jugador = " + modules[2].getDependencies().size());
        System.out.println("Ce de la clase Objeto = " + modules[3].getDependencies().size());
        System.out.println("Ce de la clase Acertijo = " + modules[4].getDependencies().size() + "\n");

        habitacion.addDependent(juego);

        jugador.addDependent(juego);

        objeto.addDependent(juego);
        objeto.addDependent(jugador);

        acertijo.addDependent(juego);
        acertijo.addDependent(jugador);

        System.out.println("ACOPLAMIENTO AFERENTE: ");
        System.out.println("Ca de la clase Juego = " + modules[0].getDependents().size());
        System.out.println("Ca de la clase Habitacion = " + modules[1].getDependents().size());
        System.out.println("Ca de la clase Jugador = " + modules[2].getDependents().size());
        System.out.println("Ca de la clase Objeto = " + modules[3].getDependents().size());
        System.out.println("Ca de la clase Acertijo = " + modules[4].getDependents().size());
    }
}