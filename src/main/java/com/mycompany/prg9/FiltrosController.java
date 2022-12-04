/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.Genero;
import com.mycompany.classes.JuegoC;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Comparator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
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
    /*
    @FXML
    private VBox vBGeneros;
    */
    
    @FXML
    private ComboBox cbGeneros;
    
    @FXML
    private Button btnVolver;
    
    @FXML
    private TextField tfTitulo;
    
    @FXML
    private FlowPane mostrador;
    
   
    
    public ArrayList<String> crearColeccion(){   //CREAR LISTA DE LAS FECHAS DE LANZAMIENTO
        ArrayList<String> fechas = new ArrayList<>();
        
        int fechaActual;
        
        for(fechaActual=2022; fechaActual>=1950;fechaActual--){
            fechas.addLast(String.valueOf(fechaActual));
        }
        return fechas;
    }
    
    public ArrayList<String> coleccionEstrellas(){ //COLECCION DE ESTRELLAS DE CALIFICACION
        
        ArrayList<String> estrellas= new ArrayList<>();
        
        for(int i=5; i>=1; i--){
            estrellas.addLast(String.valueOf(i));
        }
        
       return estrellas;
    }
  
   
    
    public void llenarCbGeneros(){ //METODO PARA LLENAR EL CB DE GENEROS
       ArrayList<String> listaGeneros;
       listaGeneros = Genero.cargarGeneros();
       
       for(String g:listaGeneros){
            cbGeneros.getItems().add(g);
       }
      
            
    }
   public void llenarCombo(){ //METODO PARA LLENAR EL CB DE FECHAS
       
      for(String fecha: crearColeccion()){
          cbFecha.getItems().add(fecha);
          
      }
   }
   
   public void llenarComboEstrellas(){ //LLENA EL CB DE ESTRELLAS DE CALIFICACION
       
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
       llenarCbGeneros();
       colocarImagenBoton();
    }    

    @FXML
    public void mostrarJuegos(ActionEvent e) throws IOException{
        
        mostrador.getChildren().clear();
        
        String generoSeleccionado = (String) cbGeneros.getValue();
        String añoSeleccionado = (String) cbFecha.getValue();
        String tituloSeleccionado = tfTitulo.getText();
        
        ArrayList<JuegoC> juegosFiltrados = JuegoC.cargarJuegos(tituloSeleccionado, añoSeleccionado, generoSeleccionado);
        
        for(Album al:BibliotecaJuegos.getListaAlbumes()){
            
        for(JuegoC j: juegosFiltrados){
            if(al.getNombre().toLowerCase().contains(j.getNombre().toLowerCase())){
                Album album=al;
            //FileInputStream stream = new FileInputStream("/com/mycompany/prg9/imagenes/"+j.getNombre()+".jpg");
            
            //Creando la imagen
            /*Image imagenJuego = new Image(stream);
            
            ImageView imvJuego = new ImageView(imagenJuego);*/
            
            URL juego = getClass().getResource("/com/mycompany/prg9/imagenes/"+j.getNombre()+".jpg");
            Image imgJuego = new Image(juego.toString(),200,300,false,false);
            ImageView imvJuego = new ImageView(imgJuego);
            //Creando labels
            Label lblNombreJuego = new Label(j.getNombre());
            //Creando Vbox
            
            VBox juegos = new VBox(imvJuego,lblNombreJuego);
            mostrador.getChildren().add(juegos);
            juegos.setOnMouseClicked(eh-> {
               if(eh.getClickCount()==1){
                  //lbumSeleccion=album;
                   //txtAlbumSel.setText("Álbum seleccionado: "+album.getNombre());
               }
               if(eh.getClickCount()==2){
                try {
                    if(album.getFotosDelAlbum().length()!=0){
                    BibliotecaJuegos.setAlbumSelec(al);
                    App.setRoot("juegoVent");
                    }
                    else{
                        
                       Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
                       alerta.setTitle("Diálogo de información");
                       alerta.setHeaderText("Álbum vacío");
                       alerta.setContentText("El álbum está vacío, quiere agregar una foto?");
                       Optional<ButtonType> result=alerta.showAndWait();
            
                       if(result.get()==ButtonType.OK){
                            //BibliotecaJuegos.setAlbumSelec(album);
                            App.setRoot("agregarFoto2");
                       }
                       
                       else{
                           App.setRoot("MenuPrincipal");
                       }
                       
                    }
                } catch (IOException ex) {
                }
               }
            });
           
           
        }
        }
       
       
        
    }
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
