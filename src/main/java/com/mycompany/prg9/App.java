package com.mycompany.prg9;

import com.mycompany.classes.Album;
import com.mycompany.classes.BibliotecaJuegos;
import com.mycompany.classes.Foto;
import com.mycompany.classes.JuegoC;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import tdas.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static ArrayList<Album> listaAlbum;
    File fileA=new File("");
    String ruta=null;
    static Image imagen;
    
     public static Scene getScene() {
        return scene;
    } 
    public static ArrayList<Album> getListaAlbum() {
        return listaAlbum;
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("pruebaPrincipal"), 640, 480);
        scene.getStylesheets().add("com/mycompany/prg9/css/InterfazCSS.css");
        stage.setTitle("Game Store");
        stage.setScene(scene);
        stage.show();
        //FotoP.serializarFoto(listaAlbum);
        /*ArrayList<String> ar= new ArrayList<>();
        ar.add("a");
        for(String c:ar){
                    System.out.println(c);

        }*/
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void cargarArchivos() throws IOException{
        listaAlbum=Album.lecturaAlbumes();
        JuegoC.setListaJ(JuegoC.lecturaJuego());
        for (Album al:listaAlbum) {
            
            Album album= new Album(al.getNombre());
            BibliotecaJuegos.getListaAlbumes().addLast(album);
            //BibliotecaJuegos.setAlbumSelec(album);
            //Foto.serializarFoto(BibliotecaJuegos.getAlbumSelec());
            
            if(!Foto.lecturaSFotos(album).estaVacia()){   
            for (int j = 0; j < Foto.lecturaSFotos(album).length();j++) {
                
                Foto picture=Foto.lecturaSFotos(album).get(j);
                //System.out.println(picture.getImagen());
                album.setFotosDelAlbumSinimagen(Foto.lecturaSFotos(album));
                File file = new File("archivos/albumes/"+album.getNombre()+"/"+picture.getNombre());
                Image image = new Image(file.toURI().toString());
               Foto foto=new Foto(picture.getNombre(),image,picture.getJuego());
               
                album.aggFotosDelAlbum(foto); 
    
            }
            }

        }
        }
    public static void main(String[] args) {
         try {
            cargarArchivos();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        launch();
    }
}