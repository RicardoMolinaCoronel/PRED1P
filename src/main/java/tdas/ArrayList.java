/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

/**
 *
 * @author Ricardo
 * @param <E>
 */
    public class ArrayList<E> implements List<E>{
  private E[] arreglo;
  private int ultimo,capacidad;
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
        /* public E get(int p){
        return arreglo[p];
    } */
  
}
