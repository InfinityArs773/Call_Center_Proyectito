
package com.mycompany.call_center_2;

import java.util.LinkedList;

/**
 * Gestiona las llamadas recibidas por el Call Center.
 * @author Erick López
 */
public class Callcenter {

    private Cola<Llamada> llamadas;
    private double tiempoTotal;
    private LinkedList<Integer> puntuaciones;

    public Callcenter() {
        llamadas = new Cola<>();
        tiempoTotal = 0;
        puntuaciones = new LinkedList<>();
    }

    public void recibirLlamada(Llamada llamada) {
        if (llamada.getTipo() == Llamada.Tipo.PRIORITARIA) {
            llamadas.enqueuePrioritario(llamada);
        } else {
            llamadas.enqueue(llamada);
        }
    }

    public Llamada atenderLlamada() {
        if (llamadas.empty()) {
            return null;
        }

        Llamada llamada = llamadas.dequeue();
        tiempoTotal += llamada.getDuracion();
        puntuaciones.add(llamada.ObtenerPuntuacion());

        return llamada;
    }

    public void cancelarLlamada() {
        if (!llamadas.empty()) {
            llamadas.dequeue();
        }
    }

    public void mostrarCola() {
        Cola<Llamada> auxiliar = new Cola<>();

        while (!llamadas.empty()) {
            Llamada llamada = llamadas.dequeue();

            System.out.println("Cliente: " + llamada.getCliente()
                    + " | Duracion: " + llamada.getDuracion());

            auxiliar.enqueue(llamada);
        }

        while (!auxiliar.empty()) {
            llamadas.enqueue(auxiliar.dequeue());
        }
    }

    public double tiempoTotalPendiente() {
        double total = 0;
        Cola<Llamada> auxiliar = new Cola<>();

        while (!llamadas.empty()) {
            Llamada llamada = llamadas.dequeue();
            total += llamada.getDuracion();
            auxiliar.enqueue(llamada);
        }

        while (!auxiliar.empty()) {
            llamadas.enqueue(auxiliar.dequeue());
        }

        return total;
    }

    public int llamadasPendientes() {
        return llamadas.size();
    }

    public void atenderTodas() {
        while (!llamadas.empty()) {
            Llamada llamada = atenderLlamada();
            int puntuacion = puntuaciones.getLast();

            System.out.println("Atendido: " + llamada.getCliente()
                    + " | Duracion: " + llamada.getDuracion()
                    + " | Puntuacion: " + puntuacion);
        }
    }

    public int obtenerpromedio() {
        if (puntuaciones.isEmpty()) {
            return 0;
        }

        int suma = 0;

        for (int puntuacion : puntuaciones) {
            suma += puntuacion;
        }

        return Math.round((float) suma / puntuaciones.size());
    }
    
    public double getTiempoTotal() {
    return tiempoTotal;
}
}
