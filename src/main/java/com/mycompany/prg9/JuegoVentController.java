/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.Foto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tdas.IteratorCL;

/**
 * FXML Controller class
 *
 * @author César
 */
public class JuegoVentController {


    @FXML
    private Label nJuego;
    @FXML
    private Label nAnio;
    @FXML
    private Label nDesarrollador;
    @FXML
    private Label nDescripcion;
    @FXML
    private Button btnAnt;
    @FXML
    private ImageView ImgMos;
    @FXML
    private Button btnSig;
     private static Foto fotoSeleccionada=new Foto();
    
    private static Album albumSeleccionado=new Album();
    private IteratorCL<Foto> iterador;
    private Iterator<Album> iteradorAlbum;
    /**
     * Initializes the controller class.
     */
    
    public void initialize() throws FileNotFoundException,IOException{
      cargarFotos(BibliotecaJuegos.getAlbumSelec());
      nJuego.setText(BibliotecaJuegos.getAlbumSelec().getNombre());
        System.out.println(fotoSeleccionada.getImagen());
        }
        
       
     public static Foto getFoto(){
        return fotoSeleccionada;
    }
    
    public static Album getAlbum(){
        return albumSeleccionado;
    }
    public void cargarFotos(Album a) throws IOException{
       iteradorAlbum=  BibliotecaJuegos.getListaAlbumes().iterator();
       
        Album album=new Album();
                    
            for(Album al:BibliotecaJuegos.getListaAlbumes()){
                if(al.equals(a)){
                    album=al;
                }
            }
            
        mostrarFoto(album);
        
        iterador= (IteratorCL<Foto>) albumSeleccionado.getFotosDelAlbum().iterator();
        
    }
    
    public void mostrarFoto(Album a){
     albumSeleccionado=a;
        fotoSeleccionada=albumSeleccionado.getFotosDelAlbum().getFirst();
        ImgMos.setImage(fotoSeleccionada.getImagen());
        //ImgMos.setImage(im);
    }
   

    @FXML
    private void mostrarSig() {
        fotoSeleccionada=iterador.next();
        
        ImgMos.setImage(fotoSeleccionada.getImagen());
        
    }
     @FXML
    private void mostrarAnt() {
        fotoSeleccionada=iterador.previous();
         //System.out.println(fotoSeleccionada);
        // System.out.println("hola");
        ImgMos.setImage(fotoSeleccionada.getImagen());
    }
    
   
   

}
