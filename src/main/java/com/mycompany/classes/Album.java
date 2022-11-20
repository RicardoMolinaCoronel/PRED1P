/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import tdas.ArrayList;
import tdas.DoubleLinkedCircularList;

/**
 *
 * @author César
 */
public class Album implements Serializable {
    private String nombre;
    private String miniatura;
    private DoubleLinkedCircularList<Foto> fotosDelAlbum =new DoubleLinkedCircularList();
    private DoubleLinkedCircularList<Foto> fotosDelAlbumSinImagen = new DoubleLinkedCircularList();
    private static final long serialVersionUID = 5555;
    public Album() {
    }

    public Album(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(String miniatura) {
        this.miniatura = miniatura;
    }

    public DoubleLinkedCircularList<Foto> getFotosDelAlbum() {
        return fotosDelAlbum;
    }

    public void setFotosDelAlbum(DoubleLinkedCircularList<Foto> fotosDelAlbum) {
        this.fotosDelAlbum = fotosDelAlbum;
    }

    public DoubleLinkedCircularList<Foto> getFotosDelAlbumSinimagen() {
        return fotosDelAlbumSinImagen;
    }

    public void setFotosDelAlbumSinimagen(DoubleLinkedCircularList<Foto> fotosDelAlbumSinimagen) {
        this.fotosDelAlbumSinImagen = fotosDelAlbumSinimagen;
    }

    public void aggFotosDelAlbum( Foto foto ) {
        fotosDelAlbum.addLast(foto);
    }
    
    public void aggFotosSinImage( Foto foto ) {
        fotosDelAlbumSinImagen.addLast(foto);
    }
    
    public String toString(){
        return nombre;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    } 
    public static ArrayList<Album> lecturaAlbumes() throws FileNotFoundException,IOException{
        ArrayList<Album> listaAlbumes = new ArrayList<>();
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader ("archivos/albumJuego.txt"))){

            String linea;
            
            int i=0;
            
            while((linea=bufferedReader.readLine())!=null){
                
                //String[] info=linea.split(",");
                Album album=new Album(linea);
                
                listaAlbumes.addLast(album);
                i++;
            }
            
        } 
    
        return listaAlbumes;
    }
    public void escribirAlbum() {
        
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/albumJuego.txt",true))) {
            sb.append("\r\n");
            sb.append(this.nombre);  
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void reescrituraAlbum(){
        
        StringBuilder sb = new StringBuilder();
        
        
        for(Album a:BibliotecaJuegos.getListaAlbumes() ){
            
            if(BibliotecaJuegos.getListaAlbumes().indexOf(a)!=0){
            sb.append("\r\n");}
            sb.append(a.nombre);
           ;
            
            
        }    
            
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/albumJuego.txt"))) {
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    
    
}
