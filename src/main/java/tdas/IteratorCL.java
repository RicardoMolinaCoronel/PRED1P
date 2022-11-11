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


import java.util.Iterator;

/**
 *
 * @author Ricardo
 */
public class IteratorCL<E> implements Iterator<E> {
    DoubleLinkedCircularList<E> cl;
    Nodo<E> i;
    int p;
    public IteratorCL(DoubleLinkedCircularList<E> cl){
        this.cl=cl;
        i=cl.primero;
        p=0;
    }
    @Override
    public boolean hasNext() {
       return i!=cl.ultimo.siguiente || p==0; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E next() {
        E tmp=i.contenido;
        i=i.siguiente;
        p++;
        return tmp;
    }
    public E previous(){
        E tmp=i.contenido;
        i=i.anterior;
        p--;
        return tmp;
    }
    public boolean hasPrevious(){
        return i!=cl.primero|| p==0;
    }
    
}
