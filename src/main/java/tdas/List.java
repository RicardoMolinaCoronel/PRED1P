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
public interface List<E> {
     boolean add(E e);
    boolean isEmpty();
    boolean add(int indice, E e);
  boolean remove(int indice);
}
