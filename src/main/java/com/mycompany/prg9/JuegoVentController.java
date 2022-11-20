/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import tdas.ArrayList;
import tdas.IteratorCL;

/**
 * FXML Controller class
 *
 * @author César
 */
public class JuegoVentController {

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

    /**
     * Initializes the controller class.
     */
    public void initialize() throws FileNotFoundException, IOException {
        colocarImagenBoton();
        //System.out.println(BibliotecaJuegos.getAlbumSelec().getNombre());
        leerJuego();
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

}
