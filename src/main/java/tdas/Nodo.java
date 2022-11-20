/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
public class Nodo<E> implements Serializable{
    E contenido;
    Nodo<E> siguiente;
    Nodo<E> anterior;
    int size = 0;
    private static final long serialVersionUID = 4443;

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
