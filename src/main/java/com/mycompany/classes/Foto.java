/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes;

import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.Album;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.scene.image.Image;
import tdas.ArrayList;
import tdas.DoubleLinkedCircularList;

/**
 *
 * @author César
 */
public class Foto implements Serializable {
    private String nombre;
    private Image imagen;
    private ArrayList<JuegoC> juego;
    private static final long serialVersionUID = 1111;
    
    public Foto(String nombre, ArrayList<JuegoC> juego) {
        this.nombre = nombre;
        this.juego = juego;
    }
    
    

    public Foto(String nombre, Image imagen, ArrayList<JuegoC> juego) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.juego = juego;
    }

    public ArrayList<JuegoC> getJuego() {
        return juego;
    }

    public void setJuego(ArrayList<JuegoC> juego) {
        this.juego = juego;
    }
    
    public Foto(String nombre, Image imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Foto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public String toString(){
        String listaJuego="";
        for(JuegoC j:juego){
            listaJuego=listaJuego+j.nombre;
        }
        return  "nombre"+nombre;// + "\n"+
                //"juegos"+listaJuego;
    }
    public String toStringJuego(){
        String listaJuego="";
        for(JuegoC j:juego){
         listaJuego=listaJuego+j.nombre;
        }
        return "juegos"+listaJuego;
    }
    
    public static ArrayList<Foto> cargarAllFotos(){
        ArrayList<Foto> listaFoto = new ArrayList<Foto>();
        for(int i = 0;i<BibliotecaJuegos.getListaAlbumes().size();i++){
            DoubleLinkedCircularList<Foto> listFotoPs=lecturaSFotos(BibliotecaJuegos.getListaAlbumes().get(i));
            for(int j = 0;j<listaFoto.size();j++ ){
                File file = new File("archivos/albumes"+BibliotecaJuegos.getListaAlbumes().get(i).getNombre()+"/"+listaFoto.get(i).getNombre());
                Image imagen = new Image(file.toURI().toString(),100,100,true,true);
                Foto foto = new Foto(listFotoPs.get(i).getNombre(),imagen);
                System.out.println(foto.imagen);
                listaFoto.insert(listaFoto.size(), foto);
            }
        
        }
        //System.out.println(listaFoto);
        return listaFoto;
}
    public static void serializarFoto(Album album)throws IOException {
        FileOutputStream fout = new FileOutputStream("archivos/albumes/"+album.getNombre()+"/infoFotos.ser");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(album.getFotosDelAlbumSinimagen());
        //System.out.println(BibliotecaP.getAlbumSelec());
        out.flush();
        out.close();
        
        }
    public static DoubleLinkedCircularList<Foto> lecturaSFotos(Album a){
        DoubleLinkedCircularList<Foto> listaFotos = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("archivos/albumes/"+a.getNombre()+"/infoFotos.ser"));
            listaFotos=(DoubleLinkedCircularList<Foto>) in.readObject();
            in.close();
        }
        
	catch (FileNotFoundException e){
            System.out.println(e);
        }

        catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }

        return listaFotos;
    }
    
   
}
