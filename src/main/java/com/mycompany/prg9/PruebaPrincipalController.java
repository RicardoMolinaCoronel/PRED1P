/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.prg9.App;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import tdas.IteratorCL;
import tdas.ArrayList;
import tdas.DoubleLinkedCircularList;

/**
 * FXML Controller class
 *
 * @author César
 */
public class PruebaPrincipalController implements Initializable {


   @FXML
    private Button filtrar;
   /*
    @FXML
    private ScrollPane scrollP;
    @FXML
    private TilePane biblioteca;
   */
    @FXML
    private TextField buscador;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnInicio;
     @FXML
    Label labelImagen1;
    @FXML
    Label labelImagen2;
    
    IteratorCL<Album> iterador;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colocarImagenBoton();
        btnInicio.setVisible(false);
   /* biblioteca.setAlignment(Pos.CENTER);
        biblioteca.setPadding(new Insets(15, 15, 15, 15));
        biblioteca.setVgap(30);
        biblioteca.setHgap(20);
        scrollP.setFitToWidth(true);
        scrollP.setContent(biblioteca);*/
        
        //scrollP.backgroundProperty().;
        //scrollP.setContent(biblioteca);
       
       //scrollP.setContent(biblioteca);
       //scrollP.setContent(bot);
        
     /*   for(Album al: BibliotecaJuegos.getListaAlbumes()){
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
            
            //biblioteca.getChildren().add(vboxalbum);
            
           
           
                 
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
*/
      System.out.println("aaaa");
        ArrayList<Album> albumes=BibliotecaJuegos.getListaAlbumes();
       
       DoubleLinkedCircularList<Album> titulos= new DoubleLinkedCircularList<>();
       for(Album al:albumes){
           if(!al.getNombre().equals("")){
           titulos.addLast(al);
           System.out.println(al.getNombre());
           }
       }
       iterador=(IteratorCL<Album>) titulos.iterator();
       ImageView imgview = null;
            try{
                //agrego la imagen de la miniatura
                
                InputStream input = App.class.getResource("imagenes/"+iterador.next().getNombre()+".jpg").openStream();
                Image img = new Image(input, 220,227, false, false);
                imgview = new ImageView(img);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                                System.out.println(titulos.get(0).getNombre());

                imgview = new ImageView();
            } 
       ImageView imgview2 = null;
            try{
                //agrego la imagen de la miniatura
                InputStream input = App.class.getResource("imagenes/"+iterador.next().getNombre()+".jpg").openStream();
                Image img = new Image(input, 220,227, false, false);
                imgview2 = new ImageView(img);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                imgview2 = new ImageView();
            }     
            
            labelImagen1.setGraphic(imgview);
            labelImagen2.setGraphic(imgview2);
        
        
        // TODO
    } 
    @FXML
    private void atras(ActionEvent event) throws IOException{
       ImageView imgview = null;
       ImageView imgview2 = null;
       iterador.previous();
       iterador.previous();
       iterador.previous();
       String tituloAtras2=iterador.previous().getNombre();
       String tituloAtras1=iterador.previous().getNombre();      
       iterador.next();
       iterador.next();
       iterador.next();
            try{
                //agrego la imagen de la miniatura               
                InputStream input = App.class.getResource("imagenes/"+tituloAtras1+".jpg").openStream();
                Image img = new Image(input, 220,227, false, false);
                imgview = new ImageView(img);
                
                InputStream input2 = App.class.getResource("imagenes/"+tituloAtras2+".jpg").openStream();
                Image img2 = new Image(input2, 220,227, false, false);
                imgview2 = new ImageView(img2);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                                
                imgview = new ImageView();
                imgview2 = new ImageView();
            }
            labelImagen1.setGraphic(imgview);
            labelImagen2.setGraphic(imgview2);
    }
    @FXML
    private void adelante(ActionEvent event) throws IOException{
       ImageView imgview = null;
       ImageView imgview2 = null;
       String tituloSiguiente1=iterador.next().getNombre();
       String tituloSiguiente2=iterador.next().getNombre();
       System.out.println(tituloSiguiente1);
       System.out.println(tituloSiguiente2);

            try{
                //agrego la imagen de la miniatura                
                InputStream input = App.class.getResource("imagenes/"+tituloSiguiente1+".jpg").openStream();
                Image img = new Image(input, 220,227, false, false);
                imgview = new ImageView(img);
                
                InputStream input2 = App.class.getResource("imagenes/"+tituloSiguiente2+".jpg").openStream();
                Image img2 = new Image(input2, 220,227, false, false);
                imgview2 = new ImageView(img2);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                                
                imgview = new ImageView();
                imgview2 = new ImageView();
            }
            labelImagen1.setGraphic(imgview);
            labelImagen2.setGraphic(imgview2);
        
    }

    
    private void colocarImagenBoton() {
        URL filtro = getClass().getResource("/com/mycompany/prg9/imagenes/filtrar.png");
        Image imgFiltro = new Image(filtro.toString(), 20, 20, false, true);
        filtrar.setGraphic(new ImageView(imgFiltro));
        URL buscar = getClass().getResource("/com/mycompany/prg9/imagenes/buscar.png");
        Image imgBuscar = new Image(buscar.toString(), 20, 20, false, true);
        btnBuscar.setGraphic(new ImageView(imgBuscar));
        URL casa = getClass().getResource("/com/mycompany/prg9/imagenes/casa.png");
        Image imgCasa = new Image(casa.toString(), 20, 20, false, true);
        btnInicio.setGraphic(new ImageView(imgCasa));
        
    }

    @FXML
    private void filtrarJuego(ActionEvent event) throws IOException{
        App.setRoot("filtros");
    }

    @FXML
    private void buscarJuego() {
        btnInicio.setVisible(true);
        System.out.println( buscador.getText());
        String busqueda = buscador.getText();
       // biblioteca.getChildren().clear();
        for(Album al: BibliotecaJuegos.getListaAlbumes()){
           // System.out.println(al);
           if(al.getNombre().toLowerCase().startsWith(busqueda.toLowerCase())){
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
            
           // biblioteca.getChildren().add(vboxalbum);
            
           
           
                 
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
        
        } 
    }

    @FXML
    private void regresoInicio(ActionEvent event) {
        btnInicio.setVisible(false);
        buscador.clear();
      //   biblioteca.getChildren().clear();
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
            
      //      biblioteca.getChildren().add(vboxalbum);
            
           
           
                 
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
        
        } 

   
        
    
    
    
}


