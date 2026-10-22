package org.example;

public class Main {
    public static void main(String[] args) {
        Pistas pistas = new Pistas();

        Vehiculo v1 = new Vehiculo("Vehículo 1", pistas);
        Vehiculo v2 = new Vehiculo("Vehículo 2", pistas);
        Vehiculo v3 = new Vehiculo("Vehículo 3", pistas);
        Vehiculo v4 = new Vehiculo("Vehículo 4", pistas);

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        try {
            v1.join();
            v2.join();
            v3.join();
            v4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas las pruebas han finalizado con éxito.");
    }
}