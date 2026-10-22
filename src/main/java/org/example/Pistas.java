package org.example;
public class Pistas {
    private boolean[] disponibles = new boolean[2];

    public Pistas() {
        disponibles[0] = true;
        disponibles[1] = true;
    }

    // Método sincronizado para pedir una pista libre
    public synchronized int ocuparPista(String nombreVehiculo) {
        while (!disponibles[0] && !disponibles[1]) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int idPista = -1;
        if (disponibles[0]) {
            idPista = 0;
            disponibles[0] = false;
        } else if (disponibles[1]) {
            idPista = 1;
            disponibles[1] = false;
        }

        System.out.println(nombreVehiculo + " ha entrado en la pista " + (idPista + 1) + ".");
        return idPista;
    }

    public synchronized void liberarPista(String nombreVehiculo, int idPista) {
        disponibles[idPista] = true;
        System.out.println(nombreVehiculo + " ha salido de la pista " + (idPista + 1) + ".");
        notifyAll();
    }
}