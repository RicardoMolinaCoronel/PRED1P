/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Ricardo
 */
public class DoubleLinkedCircularList<E> implements Iterable<E>{
     @Override
    public Iterator<E> iterator() {
return new IteratorCL(this);
    }
    
    public E findFirstElement(DoubleLinkedCircularList<E> cl, Comparator<E> cmp, E anotherElement){
        for (E element : cl) {
        if (cmp.compare(element, anotherElement) == 0) {
             return element;
        }
    }
        return null;
    }
    
    public DoubleLinkedCircularList<E> findAll (DoubleLinkedCircularList<E> elements, Comparator cmp, E anotherElement) {
    DoubleLinkedCircularList<E> results = new DoubleLinkedCircularList();
    for (E element : elements) {
        if (cmp.compare(element, anotherElement) == 0) {
             results.addLast(element);
        }
    }
    return results; 
}

    Nodo<E> primero;
    Nodo<E> ultimo;
    int size = 0;
    public DoubleLinkedCircularList(E cont) {
        primero=new Nodo(cont);
        ultimo=primero;
        ultimo.siguiente=ultimo.anterior=primero;
        primero.anterior=primero.siguiente=ultimo;
        size++;
    }
     public DoubleLinkedCircularList() {
        primero=null;
        ultimo=null;
    }
     
     //Saber el tamaño de la lista de nodos
    public int longitud() {
        return size;
    }
    //Conocer si la lista esta vacía
    public boolean estaVacia() {
        return (primero == null);
    }
    //Añadir el nodo al final
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        Nodo<E> insercion = new Nodo(e);

        if (estaVacia()) {
            ultimo=primero=insercion;
            ultimo.siguiente=ultimo.anterior=primero;
        primero.anterior=primero.siguiente=ultimo;
            //fin=insercion;
            size++;
            return true;
        } else {
            ultimo.siguiente=insercion;
            insercion.siguiente=primero;
            insercion.anterior=ultimo;
            ultimo=insercion;
            primero.anterior=ultimo;
            size++;
            return true;
        }

    }
    

    //Añadir un nodo al inicio 
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        Nodo<E> inser = new Nodo(e);
        if (estaVacia()) {
           ultimo=primero=inser;
            ultimo.siguiente=ultimo.anterior=primero;
        primero.anterior=primero.siguiente=ultimo;
            //fin=insercion;
            size++;
            return true;
        } else {
            primero.anterior=inser;
            inser.anterior=ultimo;
            inser.siguiente=primero;
            primero=inser;
            ultimo.siguiente=primero;
            //inicio=inser;            
            /*
            fin.anterior=inser;
            inser.siguiente=inicio;
            inser.anterior=fin;
            inicio=inser;
            size++;*/
            size++;
            return true;
        }
    }
    //Añadir un nodo por indice;
    public boolean add(int indice, E e) {
        if (indice < 0 || indice > longitud()) {
            throw new IndexOutOfBoundsException();
        }
        if (e == null) {
            return false;
        }
        Nodo<E> inser = new Nodo(e);
        Nodo<E> tmp = primero;

        if (indice == 0) {
            return addFirst(e);
        } else if (indice == longitud() || indice == longitud() -1 ) {
            return addLast(e);
        } else {
            for (int i = 0; i < indice - 1; i++) {
                tmp = tmp.siguiente;
            }
            inser.siguiente = tmp.siguiente;
            inser.anterior = tmp;
            tmp.siguiente = inser;
            inser.siguiente.anterior = inser;
            size++;

        }
        return true;
    }
    //Eliminar el primer nodo de la lista
    public boolean removeFirst() {
        if(primero!=null){
            Nodo<E> tmp = primero;
            primero = tmp.siguiente;
            if(primero==null){
                ultimo=null;
            }else{
                primero.anterior=ultimo;
                ultimo.siguiente=primero;
                
        size--;}
        }
        return true;
    }
    //Eliminar el último nodo de la lista
    public boolean removeLast() {
        if(ultimo!=null){
            Nodo<E> tmp = ultimo;
            ultimo=tmp.anterior;
            ultimo.siguiente=primero;
            primero.anterior=ultimo;
            size--;
        }
        return true;
    }
    //Eliminar el nodo por posición 
    public boolean remove(int indice) {
        Nodo<E> actual = new Nodo();
        Nodo<E> tmp= new Nodo();
        actual = primero;
        //previo = ultimo;
        if(indice< 0 || indice>longitud()-1){
            throw new IndexOutOfBoundsException();
        }
        do{
            if(actual.contenido==get(indice)){
                if(actual==primero){
                  return removeFirst();
                }
                else if(actual==ultimo){
                    return removeLast();
                }
                else{
                    tmp.siguiente= actual.siguiente;
                    actual.siguiente.anterior=tmp;
                    size--;
                    return true;
                }
            }
            tmp=actual;
            actual =actual.siguiente;           
        }while(actual!=primero);
        return false;
    }

    //Obtener el primer nodo de la lista            
    public E getFirst() {
        if (estaVacia()) {
            return null;
        }
        return primero.contenido;
    }

    //Obtener el último nodo de la lista
    public E getLast() {
        if (estaVacia()) {
            return null;
        }
        return ultimo.contenido;
    }
    //Obtener el nodo por indice de la lista
    public E get(int indice) {
        if (estaVacia()) {
            return null;
        }
        if (indice < 0 || indice > longitud() - 1) {
            return null;
        }
        if (indice == 0) {
            return ultimo.contenido;
        }
        if (indice == longitud() - 1) {
            return primero.contenido;
        }
        Nodo<E> tmp = primero;
        int j = 0;
        while (j < indice) {
            tmp = tmp.siguiente;
            j++;
        }
        return tmp.contenido;
    }
    /*
    public E getNext(){
        if()
    
    }*/
    //Imprimir la lista de nodos 
    public void recorrer(){
        Nodo<E> p = primero;
        do{
            System.out.print(p.contenido+"-->");
            p=p.siguiente;
        }while(p.contenido!=primero.contenido);
      
    }
    
        /*
    public void recorrer() {
        Nodo<E> tmp = inicio;
        while (tmp != null) {
            System.out.print(tmp.contenido + "-->");
            tmp = tmp.siguiente;
        }
        System.out.println(getLast());
        tmp = fin;
        while (tmp != null) {
            System.out.print(tmp.contenido + "-->");
            tmp = tmp.anterior;
        }
        System.out.println(getFirst());

    }*/
    
}

