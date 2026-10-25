/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.call_center_2;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Erick López
 */
public class Llamada {
    
    public enum Tipo{
        NORMAL, PRIORITARIA
    }
    
    private int id;
    private String cliente;
    private Tipo tipo;
    private double duracion;

    public Llamada(int id, String cliente, Tipo tipo, double duracion) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getDuracion() {
        return duracion;
    }
    
    public int ObtenerPuntuacion(){
        return ThreadLocalRandom.current().nextInt(1, 11);
    }
}