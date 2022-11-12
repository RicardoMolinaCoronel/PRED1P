/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;


/**
 *
 * @author Ricardo
 * @param <E>
 */
    public class ArrayList<E> implements List<E>,Iterable<E>{
  private E[] arreglo;
  private int ultimo,capacidad;
  
  
  public E findFirstElement(ArrayList<E> cl, Comparator<E> cmp, E anotherElement){
        for (E element : cl) {
        if (cmp.compare(element, anotherElement) == 0) {
             return element;
        }
    }
        return null;
    }
    
    public ArrayList<E> findAll (ArrayList<E> elements, Comparator cmp, E anotherElement) {
    ArrayList<E> results = new ArrayList();
    for (E element : elements) {
        if (cmp.compare(element, anotherElement) == 0) {
             results.addLast(element);
        }
    }
    return results; 
}
     public boolean addFirst(E e){
         if(ultimo+1==capacidad){
            crecerArreglo();
        }
        ultimo+=1;        
        for(int x=ultimo;x>0;x--){
        arreglo[x]=arreglo[x-1];        
        }
        arreglo[0]=e;        
        return true; 
     }
    public boolean addLast(E e){
        try{
        if(capacidad==ultimo+1){
            crecerArreglo();
        }
        ultimo+=1;
        arreglo[ultimo]=e; 
        return true;
       }catch(Exception ex){
           return false;
       }
    }
   @Override
    public Iterator<E> iterator() {
        
        Iterator<E> it=new Iterator<E>(){
            
            int i=0;
            E puntero= arreglo[i];
            
            @Override
            public boolean hasNext() {
                return i < arreglo.length && arreglo[i] != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {throw new NoSuchElementException();}
                
                return arreglo[i++];
 
            }
        
    };
        
        return it;
    }
    public ArrayList() {
        capacidad=10;
        arreglo = (E[]) new Object[capacidad];
        ultimo=-1;
    }
    private void crecerArreglo(){
        capacidad+=10;
        E[] arregloNuevo= (E[]) new Object[capacidad];
        for(int x=0;x<=ultimo;x++){
            arregloNuevo[x] = arreglo[x];
        }
        arreglo=arregloNuevo;
    }
    @Override
    public boolean add(E e) {
       try{
        if(capacidad==ultimo+1){
            crecerArreglo();
        }
        ultimo+=1;
        arreglo[ultimo]=e; 
        return true;
       }catch(Exception ex){
           return false;
       }
    }
 
   
    
  @Override
      public boolean isEmpty(){
        return ultimo==-1;
    }
     @Override
    public boolean add(int indice, E e){
        if(indice>ultimo+1 || indice<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(ultimo+1==capacidad){
            crecerArreglo();
        }
        ultimo+=1;        
        for(int x=ultimo;x>indice;x--){
        arreglo[x]=arreglo[x-1];        
        }
        arreglo[indice]=e;        
        return true; 
    }
    public boolean remove(int indice){
        if(indice>ultimo || indice<0 || isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        arreglo[indice]=null;
        ultimo-=1;
        for(int x=indice;x<=ultimo;x++){
            arreglo[x]=arreglo[x+1];
        }
        arreglo[ultimo+1]=null;
        return true;
    }
        public E get(int p){
            if(p<=0 || p>ultimo){
                throw new ArrayIndexOutOfBoundsException();
            }
        return arreglo[p];
    }
    
        @Override
    public boolean contains(E e) {
        if(e==null){
            return false;
        }
        for(E tmp:arreglo){
            if(e.equals(tmp)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
         return arreglo.toString();
    }
  
}
