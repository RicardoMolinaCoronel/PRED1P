/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tdas.*;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 * 
 * @author USER1
 */
public class FiltrosController implements Initializable {
    
    @FXML
    private ComboBox cbFecha;
    
    @FXML
    private ComboBox cbCalificacion1;
    
    @FXML
    private ComboBox cbCalificacion2;
    
    @FXML
    private VBox vBGeneros;
    @FXML
    private Button btnVolver;
    
    
    public ArrayList<String> crearColeccion(){
        ArrayList<String> fechas = new ArrayList<>();
        
        int fechaActual;
        
        for(fechaActual=2022; fechaActual>=1950;fechaActual--){
            fechas.addLast(String.valueOf(fechaActual));
        }
        return fechas;
    }
    
    public ArrayList<String> coleccionEstrellas(){
        
        ArrayList<String> estrellas= new ArrayList<>();
        
        for(int i=5; i>=1; i--){
            estrellas.addLast(String.valueOf(i));
        }
        
       return estrellas;
    }
    
    public ArrayList<String> coleccionGeneros(){
        
        ArrayList<String> generos = new ArrayList<>();
        
        generos.add("Aventura");
        generos.add("Arcade");
        generos.add("Acción");
        generos.add("Deportes");
        generos.add("Estrategia");
        generos.add("Simulación");
        
        return generos;
                
    }
    
    public void llenarCb(){
        for(String genero: coleccionGeneros()){
            CheckBox cb = new CheckBox(genero);
            vBGeneros.getChildren().add(cb);
        }
    }
    
   public void llenarCombo(){
       
      for(String fecha: crearColeccion()){
          cbFecha.getItems().add(fecha);
          
      }
   }
   
   public void llenarComboEstrellas(){
       
       for(String estrella: coleccionEstrellas()){
           cbCalificacion1.getItems().add(estrella);
           cbCalificacion2.getItems().add(estrella);
       }
   }
                
   
   


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       llenarCombo();
       llenarComboEstrellas();
       llenarCb();
       colocarImagenBoton();
    }    

    @FXML
    private void volver(ActionEvent event) throws IOException{
        App.setRoot("pruebaPrincipal");
    }
    
     private void colocarImagenBoton() {
       
        URL linkAtras = getClass().getResource("/com/mycompany/prg9/imagenes/atras.png");
        Image imgAtras = new Image(linkAtras.toString(), 20, 20, false, true);
        btnVolver.setGraphic(new ImageView(imgAtras));
    }
    
}
