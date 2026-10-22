package org.example;

public class Vehiculo extends Thread {
    private String nombre;
    private Pistas pistas;

    public Vehiculo(String nombre, Pistas pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    @Override
    public void run() {
        int idPista = pistas.ocuparPista(this.nombre);
        long tiempoMilis = (long) (2000 + Math.random() * 3000);

        try {
            Thread.sleep(tiempoMilis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        double tiempoSegundos = tiempoMilis / 1000.0;
        System.out.println(this.nombre + " completó la prueba en " + tiempoSegundos + " segundos.");
        pistas.liberarPista(this.nombre, idPista);
    }
}