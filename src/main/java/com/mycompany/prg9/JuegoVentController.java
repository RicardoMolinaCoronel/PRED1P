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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
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

    public Text getnJuego() {
        return nJuego;
    }

    public void setnJuego(Text nJuego) {
        this.nJuego = nJuego;
    }

    public Text getnAnio() {
        return nAnio;
    }

    public void setnAnio(Text nAnio) {
        this.nAnio = nAnio;
    }

    public Text getnDesarrollador() {
        return nDesarrollador;
    }

    public void setnDesarrollador(Text nDesarrollador) {
        this.nDesarrollador = nDesarrollador;
    }

    public Text getnDescripcion() {
        return nDescripcion;
    }

    public void setnDescripcion(Text nDescripcion) {
        this.nDescripcion = nDescripcion;
    }

    public Text getnGenero() {
        return nGenero;
    }

    public void setnGenero(Text nGenero) {
        this.nGenero = nGenero;
    }
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
        ArrayList<Comentario> coment =  Comentario.lecturaAlbum(juego.getNombre());
        Label comen = new Label("Comentarios:");
        String orden = ordenComen.getValue();
        System.out.println(orden);
        
        comentA.getChildren().clear();
        comentA.getChildren().addAll(comen,ordenComen);
        Label comentarios = new Label("Comentarios:");
        PriorityQueue<Comentario> comentariosOrdenados=null;        ///comentA.getChildren().addAll(comentarios,ordenComen);
        if(orden.equals("Mayor Calificación")){
            comentariosOrdenados=new PriorityQueue<Comentario>((Comentario c1,Comentario c2)->{
                return c2.getCalificacion()-c1.getCalificacion();
            });
          
            for(Comentario c: coment){
                comentariosOrdenados.offer(c);
            }

        }
        else if(orden.equals("Menor Calificación")){
            comentariosOrdenados=new PriorityQueue<Comentario>((Comentario c1,Comentario c2)->{
                return c1.getCalificacion()-c2.getCalificacion();
            });
             for(Comentario c: coment){
                comentariosOrdenados.offer(c);
            }
            
        }
        else if(orden.equals("Más reciente")){
            comentariosOrdenados=new PriorityQueue<Comentario>((Comentario c1,Comentario c2)->{
                String[] split1=c1.getFecha().split("/");
                String[] split2=c2.getFecha().split("/");
                int[] v1=new int[3];
                int[] v2=new int[3];
                for(int x=0;x<3;x++){
                    v1[x]=Integer.valueOf(split1[x]);
                    v2[x]=Integer.valueOf(split2[x]);
                }
                return ((v2[0]-v1[0]))+((v2[1]-v1[1])*30)+((v2[2]-v1[2])*365);
            });            
            for(Comentario c: coment){
                comentariosOrdenados.offer(c);
            }
        }
        else if(orden.equals("Más antiguo")){
            
             comentariosOrdenados=new PriorityQueue<Comentario>(new Comparator<Comentario>() {
                 @Override
                 public int compare(Comentario c1, Comentario c2) {
                     
                     String[] split1=c1.getFecha().split("/");                    
                     String[] split2=c2.getFecha().split("/");
                     
                     int[] v1=new int[3];
                     int[] v2=new int[3];
                     
                     for(int x=0;x<3;x++){
                         v1[x]=Integer.valueOf(split1[x]);
                         v2[x]=Integer.valueOf(split2[x]);
                     }
                     int valor=((v1[0]-v2[0]))+((v1[1]-v2[1])*30)+((v1[2]-v2[2])*365);
                     return valor;
                 }
             });
             
             for(Comentario c: coment){
                comentariosOrdenados.offer(c);
            }
      
        }
        if(orden!=null){
            Comentario c;
          while (!comentariosOrdenados.isEmpty()) {
                c=comentariosOrdenados.poll();
                 
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
    }
    
    public void infoMostrarCombo(){
        ordenComen.getItems().add("Más reciente");
        ordenComen.getItems().add("Más antiguo");
        ordenComen.getItems().add("Mayor Calificación");
        ordenComen.getItems().add("Menor Calificación");
    }

    @Override
    public int compareTo(Comentario o) {
       return 1;
    }

}
