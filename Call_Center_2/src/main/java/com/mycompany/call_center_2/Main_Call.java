package com.mycompany.call_center_2;

/**
 * Programa principal para probar el Call Center.
 * @author Erick López
 */
public class Main_Call {

    public static void main(String[] args) {

        Callcenter centro = new Callcenter();

        // Registrar llamadas normales y prioritarias.
        centro.recibirLlamada(
                new Llamada(1, "Raul", Llamada.Tipo.NORMAL, 5.5));

        centro.recibirLlamada(
                new Llamada(2, "Alberto", Llamada.Tipo.NORMAL, 3.0));

        centro.recibirLlamada(
                new Llamada(3, "Damian", Llamada.Tipo.PRIORITARIA, 7.0));

        centro.recibirLlamada(
                new Llamada(4, "Esmeralda", Llamada.Tipo.PRIORITARIA, 4.5));

        // Mostrar las llamadas pendientes.
        System.out.println("=== LLAMADAS PENDIENTES ===");
        centro.mostrarCola();

        System.out.println("Cantidad pendiente: "
                + centro.llamadasPendientes());

        System.out.println("Tiempo pendiente: "
                + centro.tiempoTotalPendiente());

        // Atender una llamada.
        System.out.println("\n=== ATENDER UNA LLAMADA ===");

        Llamada atendida = centro.atenderLlamada();

        if (atendida != null) {
            System.out.println("Cliente atendido: "
                    + atendida.getCliente());

            System.out.println("Duracion: "
                    + atendida.getDuracion());
        }

        // Cancelar la siguiente llamada.
        System.out.println("\n=== CANCELAR LLAMADA ===");
        centro.cancelarLlamada();

        // Atender todas las llamadas restantes.
        System.out.println("\n=== ATENDER TODAS ===");
        centro.atenderTodas();

        // Mostrar los resultados finales.
        System.out.println("\n=== RESULTADOS FINALES ===");

        System.out.println("Tiempo total atendido: "
                + centro.getTiempoTotal());

        System.out.println("Llamadas pendientes: "
                + centro.llamadasPendientes());

        System.out.println("Promedio de puntuaciones: "
                + centro.obtenerpromedio());
    }
}
