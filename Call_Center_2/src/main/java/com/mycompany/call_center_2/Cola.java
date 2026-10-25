/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.call_center_2;

/**
 *
 * @author Erick López
 */
public class Cola<T> {

    private class Nodo{
        T dato; 
        Nodo siguiente;
        
        Nodo (T dato){
            this.dato = dato;  
        }
    }
    
    private Nodo inicio;
    private Nodo fin;
    private int cantidad;
    
     // Creamos una cola vacía.
    public Cola() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    // Insertamos un elemento al final.
    public void enqueue(T dato) {
        Nodo nuevo = new Nodo(dato);

        if (empty()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        cantidad++;
    }

    // Extraemos y retornamos el primer elemento.
    public T dequeue() {
        if (empty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        T dato = inicio.dato;
        inicio = inicio.siguiente;
        cantidad--;

        if (inicio == null) {
            fin = null;
        }

        return dato;
    }

    // Consultamos el primer elemento sin extraerlo.
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        return inicio.dato;
    }

    // Indicamos si la cola está vacía.
    public boolean empty() {
        return inicio == null;
    }

    // Retorna la cantidad de elementos.
    public int size() {
        return cantidad;
    }

    // Insertar un elemento al principio de la cola.
    public void enqueuePrioritario(T dato) {
        Nodo nuevo = new Nodo(dato);

        if (empty()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }

        cantidad++;
    }
}
