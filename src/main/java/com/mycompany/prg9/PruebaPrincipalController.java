/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author César
 */
public class PruebaPrincipalController implements Initializable {


    @FXML
    private ScrollPane scrollP;
    @FXML
    private TilePane biblioteca;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    biblioteca.setAlignment(Pos.CENTER);
        biblioteca.setPadding(new Insets(15, 15, 15, 15));
        biblioteca.setVgap(30);
        biblioteca.setHgap(20);
        Button bot = new Button("hjhj");
        //scrollP.setContent(biblioteca);
       
       //scrollP.setContent(biblioteca);
       //scrollP.setContent(bot);
        
        for(Album al: BibliotecaJuegos.getListaAlbumes()){
           // System.out.println(al);
            Album album=al;
            

            VBox vboxalbum = new VBox();
            ImageView imgview = null;
            try{
                //agrego la imagen de la miniatura
                
                InputStream input = App.class.getResource("imagenes/"+al.getNombre()+".jpg").openStream();
                Image img = new Image(input, 200,200, false, false);
                imgview = new ImageView(img);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                imgview = new ImageView();
            } 
            
            
            
            vboxalbum.getChildren().add(imgview);
            vboxalbum.getChildren().add(new Label(album.getNombre()));
            //vboxalbum.getChildren().add(new Label(album.getDescripcion()));
            
            biblioteca.getChildren().add(vboxalbum);
            
           
           
                 
           vboxalbum.setOnMouseClicked(eh-> {
               if(eh.getClickCount()==1){
                  //lbumSeleccion=album;
                   //txtAlbumSel.setText("Álbum seleccionado: "+album.getNombre());
               }
               if(eh.getClickCount()==2){
                try {
                    if(album.getFotosDelAlbum().length()!=0){
                    BibliotecaJuegos.setAlbumSelec(album);
                    App.setRoot("juegoVent");
                    }
                    else{
                        
                       Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
                       alerta.setTitle("Diálogo de información");
                       alerta.setHeaderText("Álbum vacío");
                       alerta.setContentText("El álbum está vacío, quiere agregar una foto?");
                       Optional<ButtonType> result=alerta.showAndWait();
            
                       if(result.get()==ButtonType.OK){
                            BibliotecaJuegos.setAlbumSelec(album);
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
        // TODO
    }    
    
    
}
