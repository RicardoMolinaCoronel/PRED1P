/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.Comentario;
import com.mycompany.classes.Foto;
import com.mycompany.classes.JuegoC;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tdas.ArrayList;
import tdas.IteratorCL;

/**
 * FXML Controller class
 *
 * @author César
 */
public class JuegoVentController implements Comparable<Comentario>{

    @FXML
    private Text nJuego;
    @FXML
    private Text nAnio;
    @FXML
    private Text nDesarrollador;
    @FXML
    private Text nDescripcion;
    @FXML
    private Text nGenero;
    @FXML
    private Button btnAnt;
    @FXML
    private ImageView ImgMos;
    @FXML
    private Button btnSig;
    @FXML
    private Button btnRegresar;
    private static Foto fotoSeleccionada = new Foto();
    public static JuegoC juego = new JuegoC();
    private static Album albumSeleccionado = new Album();
    private IteratorCL<Foto> iterador;
    private Iterator<Album> iteradorAlbum;
    @FXML
    private VBox comentA;
    @FXML
    private ComboBox<String> ordenComen;

    /**
     * Initializes the controller class.
     */
    public void initialize() throws FileNotFoundException, IOException {
        colocarImagenBoton();
        //System.out.println(BibliotecaJuegos.getAlbumSelec().getNombre());
        leerJuego();
        leerComentario();
        infoMostrarCombo();
        
        /*
        nJuego.setDisable(true);
        nAnio.setDisable(true);
        nDesarrollador.setDisable(true);
        nDescripcion.setDisable(true);*/
        if (BibliotecaJuegos.getAlbumSelec().getFotosDelAlbum().length() == 1) {
            btnAnt.setDisable(true);
            btnAnt.setVisible(false);
            btnSig.setDisable(true);
            btnSig.setVisible(false);
        } else {
            btnAnt.setDisable(false);
            btnAnt.setVisible(true);
            btnSig.setDisable(false);
            btnSig.setVisible(true);
        }
        cargarFotos(BibliotecaJuegos.getAlbumSelec());
        nJuego.setText(juego.getNombre());
        nAnio.setText(juego.getFecha());
        nDesarrollador.setText(juego.getDesarrollador());
        nGenero.setText(juego.getGenero());
        nDescripcion.setText(juego.getDescripcion());

    }

    public static Foto getFoto() {
        return fotoSeleccionada;
    }

    public static Album getAlbum() {
        return albumSeleccionado;
    }

    public void cargarFotos(Album a) throws IOException {
        iteradorAlbum = BibliotecaJuegos.getListaAlbumes().iterator();

        Album album = new Album();

        for (Album al : BibliotecaJuegos.getListaAlbumes()) {
            if (al.equals(a)) {
                album = al;
            }
        }

        mostrarFoto(album);

        iterador = (IteratorCL<Foto>) albumSeleccionado.getFotosDelAlbum().iterator();

    }

    public void mostrarFoto(Album a) {
        albumSeleccionado = a;
        fotoSeleccionada = albumSeleccionado.getFotosDelAlbum().getFirst();
        ImgMos.setImage(fotoSeleccionada.getImagen());
        //ImgMos.setImage(im);
    }

    @FXML
    private void mostrarSig() {
        fotoSeleccionada = iterador.next();

        ImgMos.setImage(fotoSeleccionada.getImagen());

    }

    @FXML
    private void mostrarAnt() {
        fotoSeleccionada = iterador.previous();
        //System.out.println(fotoSeleccionada);
        // System.out.println("hola");
        ImgMos.setImage(fotoSeleccionada.getImagen());
    }

    @FXML
    private void regresarMenu() throws IOException {
        App.setRoot("pruebaPrincipal");

    }

    private void colocarImagenBoton() {
        URL linkAntes = getClass().getResource("/com/mycompany/prg9/imagenes/anterior.png");
        URL linkDespues = getClass().getResource("/com/mycompany/prg9/imagenes/siguiente-boton.png");
        URL linkAtras = getClass().getResource("/com/mycompany/prg9/imagenes/atras.png");
        Image imgAntes = new Image(linkAntes.toString(), 20, 20, false, true);
        Image imgDespues = new Image(linkDespues.toString(), 20, 20, false, true);
        Image imgAtras = new Image(linkAtras.toString(), 20, 20, false, true);
        btnAnt.setGraphic(new ImageView(imgAntes));
        btnSig.setGraphic(new ImageView(imgDespues));
        btnRegresar.setGraphic(new ImageView(imgAtras));
    }

    public void leerJuego() {
        for (JuegoC j : juego.lecturaJuego()) {
            if (j.getNombre().toLowerCase().equals(BibliotecaJuegos.getAlbumSelec().getNombre().toLowerCase())) {
                juego = new JuegoC(j.getNombre(), j.getDesarrollador(), j.getFecha(), j.getGenero(), j.getDescripcion());
            }
        }
    }
    public void leerComentario(){
        ArrayList<Comentario> comentarios = Comentario.lecturaAlbum(juego.getNombre());
        for(Comentario c:comentarios){
            HBox cont = new HBox();
            Label usuario = new Label(c.getUsuario());
            Label fecha = new Label(c.getFecha());
            Text descripcion = new Text(c.getDescripcion());
            int cal = c.getCalificacion();
            for(int i=0;i<cal;i++){
                URL linkEstrella = getClass().getResource("/com/mycompany/prg9/imagenes/star.png");
                Image imgEstrella = new Image(linkEstrella.toString(), 20, 20, false, true);
                ImageView estrella = new ImageView(imgEstrella);
                cont.getChildren().add(estrella);
                
            }
            comentA.getChildren().addAll(cont,usuario,fecha,descripcion);
        }
    }

    @FXML
    private void mostrarOrden(ActionEvent event) {
        ArrayList<Comentario> coment = Comentario.lecturaAlbum(juego.getNombre());
        
        String orden = ordenComen.getValue();
        System.out.println(orden);
        comentA.getChildren().clear();
        Label comentarios = new Label("Comentarios:");
        comentA.getChildren().addAll(comentarios,ordenComen);
        
        if(orden.equals("Mayor Calificación")){
            /*ArrayList<Integer> num = new ArrayList<Integer>();
            for(Comentario c:coment){
                
                num.add(c.getCalificacion());
            }
            //Collections.sort(num);
            Comparator<Comentario> compareByCalificacion =new Comparator<Comentario>(){
                @Override
                public int compare(Comentario o1, Comentario o2) {
                    if(o1.getCalificacion()==o2.getCalificacion()){
                        return 0;
                    }
                    else return 1;
                }
           
        
        };*/
            
        }
        else if(orden.equals("Menor Calificación")){
            
        }
        else if(orden.equals("Fecha Mayor a Menor")){
            
        }
        else if(orden.equals("Fecha Menor a Mayor")){
            
        }
    }
    
    public void infoMostrarCombo(){
        ordenComen.getItems().add("Fecha Mayor a Menor");
        ordenComen.getItems().add("Fecha Menor a Mayor");
        ordenComen.getItems().add("Mayor Calificación");
        ordenComen.getItems().add("Menor Calificación");
    }

    @Override
    public int compareTo(Comentario o) {
       return 1;
    }

}