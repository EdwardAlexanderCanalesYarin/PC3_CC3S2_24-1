package org.example;

public class CalculoFactorDeAcoplamiento {
    public static void main(String[] args) {
        /*
        Juego
        Habitacion
        Jugador
        Objeto
        Acertijo
        */
        Module juego = new Module("Juego");
        Module habitacion = new Module("Habitacion");
        Module jugador = new Module("Jugador");
        Module objeto = new Module("Objeto");
        Module acertijo = new Module("Acertijo");

        juego.addDependency(juego);
        juego.addDependency(habitacion);
        juego.addDependency(jugador);
        juego.addDependency(objeto);
        juego.addDependency(acertijo);

        jugador.addDependency(objeto);
        jugador.addDependency(acertijo);
        Module[] modules = {juego,habitacion,jugador,objeto,acertijo};

        int totalDependencies = 0;
        for (Module module : modules) {
            totalDependencies += module.getDependencies().size();
        }

        int totalModules = modules.length;

        double factor_acoplamiento = (double) totalDependencies / (totalModules * (totalModules - 1));
        System.out.println("Factor de acoplamiento: " + factor_acoplamiento);
    }
}