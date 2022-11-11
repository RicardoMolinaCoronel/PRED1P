/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

/**
 *
 * @author Ricardo
 */
public class Nodo<E> {
    E contenido;
    Nodo<E> siguiente;
    Nodo<E> anterior;
    int size = 0;

    public Nodo(E cont) {
        contenido = cont;
        siguiente = null;
        anterior = null;
    }

    public Nodo() {
        siguiente = null;
        anterior = null;
    }
}
