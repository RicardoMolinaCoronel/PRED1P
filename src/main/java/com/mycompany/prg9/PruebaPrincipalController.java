/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.JuegoC;
import com.mycompany.prg9.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
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
   
    @FXML
    private ScrollPane scrollP;
    @FXML
    private TilePane biblioteca;
   
    @FXML
    private TextField buscador;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnInicio;
     @FXML
    private Label labelImagen1;
    @FXML
    private Label labelImagen2;
    @FXML
    private Label labelTextoJuego1;
    @FXML
    private Label labelTextoJuego2;
    @FXML
    private HBox hboxPrincipal;
    
    
    IteratorCL<Album> iterador;
    Album alImagen1=null;
    Album alImagen2=null;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnAdelante;
    @FXML
    private Button botonIniciarSesion;
    @FXML
    private Text usuario;
    @FXML
    private Button botonListaDeseos;
    /**
     * Initializes the controller class.
     */
    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
       if(App.inicioSesion){
           App.inicioSesion=false;
           App.usuarioIniciado=null;
           App.listaDeseos= new ArrayList<>();
           botonIniciarSesion.setText("Iniciar Sesión");
           usuario.setText("");
           App.setRoot("pruebaPrincipal");
       }else{
                  App.setRoot("iniciarSesion");
       }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colocarImagenBoton();
        btnInicio.setVisible(false);
        if(App.inicioSesion){
            usuario.setText("Usuario: "+App.usuarioIniciado);
            botonIniciarSesion.setText("Cerrar Sesión");
            URL cerrarS = getClass().getResource("/com/mycompany/prg9/imagenes/cerrarSesion.png");
            Image imgCerrarS = new Image(cerrarS.toString(), 20, 20, false, true);
            botonIniciarSesion.setGraphic(new ImageView(imgCerrarS));
            
        }
        
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
       alImagen1=iterador.next();
       alImagen2=iterador.next();
       String titulo1=alImagen1.getNombre();
       String titulo2=alImagen2.getNombre();
       
            try{
                //agrego la imagen de la miniatura
                
                InputStream input = App.class.getResource("imagenes/"+titulo1+".jpg").openStream();
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
                InputStream input = App.class.getResource("imagenes/"+titulo2+".jpg").openStream();
                Image img = new Image(input, 220,227, false, false);
                imgview2 = new ImageView(img);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                imgview2 = new ImageView();
            }     
            
            labelImagen1.setGraphic(imgview);
            labelImagen2.setGraphic(imgview2);
            labelTextoJuego1.setText(titulo1);
            labelTextoJuego2.setText(titulo2);
        
        // TODO
    } 
    @FXML
    private void atras(ActionEvent event) throws IOException{
       ImageView imgview = null;
       ImageView imgview2 = null;
       iterador.previous();
       iterador.previous();
       iterador.previous();
       alImagen1=iterador.previous();
       alImagen2=iterador.previous();
       String tituloAtras1=alImagen1.getNombre();
       String tituloAtras2=alImagen2.getNombre();
       
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
            labelTextoJuego1.setText(tituloAtras1);
            labelTextoJuego2.setText(tituloAtras2);
    }
    @FXML
    private void adelante(ActionEvent event) throws IOException{
       ImageView imgview = null;
       ImageView imgview2 = null;
       alImagen1=iterador.next();
       alImagen2=iterador.next();
       String tituloSiguiente1=alImagen1.getNombre();
       String tituloSiguiente2=alImagen2.getNombre();
       
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
            labelTextoJuego1.setText(tituloSiguiente1);
            labelTextoJuego2.setText(tituloSiguiente2);
    }

    
    private void colocarImagenBoton() {
        URL filtro = getClass().getResource("/com/mycompany/prg9/imagenes/filtrar.png");
        Image imgFiltro = new Image(filtro.toString(), 20, 20, false, false);
        filtrar.setGraphic(new ImageView(imgFiltro));
        URL buscar = getClass().getResource("/com/mycompany/prg9/imagenes/buscar.png");
        Image imgBuscar = new Image(buscar.toString(), 20, 20, false, true);
        btnBuscar.setGraphic(new ImageView(imgBuscar));
        URL casa = getClass().getResource("/com/mycompany/prg9/imagenes/casa.png");
        Image imgCasa = new Image(casa.toString(), 20, 20, false, true);
        btnInicio.setGraphic(new ImageView(imgCasa));
         URL linkAntes = getClass().getResource("/com/mycompany/prg9/imagenes/anterior.png");
        URL linkDespues = getClass().getResource("/com/mycompany/prg9/imagenes/siguiente-boton.png");
        Image imgAntes = new Image(linkAntes.toString(), 20, 20, false, true);
        Image imgDespues = new Image(linkDespues.toString(), 20, 20, false, true);
         btnAtras.setGraphic(new ImageView(imgAntes));
        btnAdelante.setGraphic(new ImageView(imgDespues));
        URL listaD = getClass().getResource("/com/mycompany/prg9/imagenes/listaDeseos.png");
        Image imgListaD = new Image(listaD.toString(), 20, 20, false, true);
        botonListaDeseos.setGraphic(new ImageView(imgListaD));
        URL inicioS = getClass().getResource("/com/mycompany/prg9/imagenes/inicioSesion.png");
        Image imgInicioS = new Image(inicioS.toString(), 20, 20, false, true);
        botonIniciarSesion.setGraphic(new ImageView(imgInicioS));
        
        
    }

    @FXML
    private void filtrarJuego(ActionEvent event) throws IOException{
        App.setRoot("filtros");
    }
    
    @FXML
    private void listaDeseos(ActionEvent event) throws IOException{
        if(App.inicioSesion){
   cargarJuegosDeseos();
        }else{
            App.setRoot("iniciarSesion");
        }
    }
    private void cargarJuegosDeseos(){

        btnInicio.setVisible(true);
        biblioteca.getChildren().clear();
      for(Album al: BibliotecaJuegos.getListaAlbumes()){
           // System.out.println(al);
           if(App.listaDeseos.contains(al.getNombre())){
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
            HBox nombreYEliminar= new HBox();
            nombreYEliminar.getChildren().add(new Label(album.getNombre()));
            nombreYEliminar.setSpacing(15);
            Button botonEliminar= new Button("Eliminar");
            URL eliminar = getClass().getResource("/com/mycompany/prg9/imagenes/borrar.png");
            Image imgEliminar = new Image(eliminar.toString(), 20, 20, false, true);
            botonEliminar.setGraphic(new ImageView(imgEliminar));
            botonEliminar.setOnAction(e -> {
                
App.listaDeseos.remove(al.getNombre());
 String lineaDeseados="";
        String[] lineaSplit;
        ArrayList<String> lineas= new ArrayList<>();
        try(BufferedReader bufferedReader =new BufferedReader(new FileReader("archivos/usuarios.txt"))){
            String linea;
            int x=0;
            
            while((linea=bufferedReader.readLine())!=null){
                lineas.addLast(linea);
            }
            bufferedReader.close();
        }catch (IOException ex) { 
            ex.printStackTrace();
        }
        
        BufferedWriter bw = null;
		try {
			File fichero = new File("archivos/usuarios.txt");
			System.out.println(fichero.getCanonicalPath()); // Path completodonde se creará el fichero.
			bw = new BufferedWriter(new FileWriter(fichero));                        
                        for(String l:lineas){
          
            lineaSplit=l.split(";");
            if(lineaSplit[0].equals(App.usuarioIniciado)){
            int i=0;    
                for(String s:App.listaDeseos){
                    if(i!=0){
                lineaDeseados+=(",");
                i++;
                    }
                    lineaDeseados+=(s);
                }               
                if(lineaDeseados.equals("")){
                    lineaDeseados+=",";
                }
                lineaSplit[2]=lineaDeseados;
            String lineaDeArchivo="";
            for(int x=0;x<2;x++){
                lineaDeArchivo+=lineaSplit[x]+";";
            }
            lineaDeArchivo+=lineaDeseados;
            bw.write(lineaDeArchivo);
            bw.newLine();
            }else{
                  bw.write(l);
            bw.newLine();
            }
        }
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bw.close(); // Cerramos el buffer
			} catch (Exception ex) {
			}
                         cargarJuegosDeseos();
    }
        });
            nombreYEliminar.getChildren().add(botonEliminar);
            vboxalbum.getChildren().add(nombreYEliminar);
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
        
        } 
        
        
    } 
    @FXML
    private void buscarJuego() {
        btnInicio.setVisible(true);
        System.out.println( buscador.getText());
        String busqueda = buscador.getText();
       biblioteca.getChildren().clear();
       
      
      
      
       
        for(Album al: BibliotecaJuegos.getListaAlbumes()){
           // System.out.println(al);
           if(al.getNombre().toLowerCase().contains(busqueda.toLowerCase())){
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
        
        } 
    }

    @FXML
    private void clickImagen1(MouseEvent ev) throws IOException{
        BibliotecaJuegos.setAlbumSelec(alImagen1);
        App.setRoot("juegoVent");
        
    }
    @FXML
    private void clickImagen2(MouseEvent ev) throws IOException{
        BibliotecaJuegos.setAlbumSelec(alImagen2);
        App.setRoot("juegoVent");
    }
    
    
    @FXML
    private void regresoInicio(ActionEvent event) {
        btnInicio.setVisible(false);
        buscador.clear();
        biblioteca.getChildren().clear();
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
       alImagen1=iterador.next();
       alImagen2=iterador.next();
       String titulo1=alImagen1.getNombre();
       String titulo2=alImagen2.getNombre();
       
            try{
                //agrego la imagen de la miniatura
                
                InputStream input = App.class.getResource("imagenes/"+titulo1+".jpg").openStream();
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
                InputStream input = App.class.getResource("imagenes/"+titulo2+".jpg").openStream();
                Image img = new Image(input, 220,227, false, false);
                imgview2 = new ImageView(img);
            }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                imgview2 = new ImageView();
            }     
            
            labelImagen1.setGraphic(imgview);
            labelImagen2.setGraphic(imgview2);
            labelTextoJuego1.setText(titulo1);
            labelTextoJuego2.setText(titulo2);
        
        biblioteca.getChildren().add(hboxPrincipal);
        /* for(Album al: BibliotecaJuegos.getListaAlbumes()){
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
*/
        
        } 

   
        
    
    
    
}


