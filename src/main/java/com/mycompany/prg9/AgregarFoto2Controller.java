/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.Foto;
import com.mycompany.classes.JuegoC;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import tdas.ArrayList;
/**
 * FXML Controller class
 *
 * @author César
 */
public class AgregarFoto2Controller implements Initializable {


    @FXML
    private Button btonCancelar;
    @FXML
    private Button btonGuardar;
    @FXML
    private ComboBox<JuegoC> cmbJuegos;
    @FXML
    private ComboBox<Album> cmbAlbum;
    @FXML
    private TextField nomFoto;
    @FXML
    private Button btnBuscar;
    @FXML
    private ImageView imgSelecc;
    String ruta=null;
    File file=new File("");
    Image image;
    ArrayList<JuegoC> listaJuegoSeleccionado= new ArrayList<JuegoC>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       for(Album a:BibliotecaJuegos.getListaAlbumes()){
            cmbAlbum.getItems().add(a);
        }
        for(JuegoC juego:JuegoC.lecturaJuego()){
            cmbJuegos.getItems().addAll(juego);}
            btnBuscar.setDisable(false);
            btnBuscar.setVisible(true);
            imgSelecc.imageProperty().set(null);
            btonGuardar.setOnMouseClicked(eh->{try {
                guardarFoto();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        
        }
        // TODO
      
    


    @FXML
    private void buscarFoto() {
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".imágenes(.jpg, .png) ", "jpg", "png");
        fileChooser.setFileFilter(filtro);
        fileChooser.showOpenDialog(fileChooser);
        try {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();                                        
            File f = new File(ruta);
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                System.out.println(entrada.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        
        }
        
        file = new File(ruta);
        
        image = new Image(file.toURI().toString());
        
        imgSelecc.setImage(image);
        nomFoto.setText(file.getName());
        
    }
    public void guardarFoto() throws IOException{
       /* try{
            
        if(image==null){
            throw new AlbumException("No se ha seleccionado una foto");
        }*/
        
        Album albumDestino=cmbAlbum.getSelectionModel().getSelectedItem();
        
       /* if(albumDestino==null){
            throw new AlbumException("No se ha seleccionado un álbum");
        }*/
        Path path1=Paths.get(ruta);
        Path path2=Paths.get("archivos//albumes//"+albumDestino.getNombre()+"//"+nomFoto.getText());
        
        ArrayList<JuegoC> listaJuegoFoto=new  ArrayList<JuegoC>();
        
        for(JuegoC juego:listaJuegoSeleccionado){
            listaJuegoFoto.addLast(juego);
        }
        
        Foto foto=new Foto(nomFoto.getText(),image, listaJuegoFoto);
        
        Foto foto2=new Foto(nomFoto.getText(),listaJuegoFoto);
        /*
        if(foto.getNombre().equals("")){
            throw new AlbumException("Nombre vacío");
        }*/
       
      
            
        Files.copy(path1, path2);
       
        
        //Album albumAgregar=new Album();
  
        
       albumDestino.aggFotosDelAlbum(foto);
       albumDestino.aggFotosSinImage(foto2);
       Foto.serializarFoto(albumDestino);
       App.setRoot("pruebaPrincipal");
        
        
    }

    @FXML
    private void comboboxEvents(ActionEvent e) {
        Object evt = e.getSource();
        JuegoC juego = cmbJuegos.getSelectionModel().getSelectedItem();
        
        if (evt.equals(cmbJuegos)) {
            Button nombre = new Button();
            nombre.setText(juego.getNombre());
            
            try {
                if (listaJuegoSeleccionado == null) {
                    
                    listaJuegoSeleccionado.addFirst(juego);
                } else {
                    if (listaJuegoSeleccionado.contains(juego)) {
                        System.out.println("YA EXISTE");
                    } else {
                        
                        listaJuegoSeleccionado.addLast(juego);
                    }
                }
            } catch (NullPointerException f) {
                System.out.println("NullPointerException thrown!");
            }

        }
    }
    
    public static void mostrarAlerta(Alert.AlertType tipo, String msj){
        Alert alert= new Alert(tipo);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText(msj);
        alert.showAndWait();
        
    }
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("pruebaPrincipal");
    }
}
