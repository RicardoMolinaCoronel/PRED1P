/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prg9;

import com.mycompany.classes.JuegoC;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class IniciarSesionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnRegresar;
    @FXML
    TextField textUsuario;
    @FXML
    TextField textPassword;
    @FXML
    Text texto;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colocarImagenBoton();
    }
    @FXML
    private void regresarMenu() throws IOException {
        App.setRoot("pruebaPrincipal");

    }
    @FXML
    private void registrarse() throws IOException {
        App.setRoot("registrarse");

    }
    
    @FXML
    private void aceptar() throws IOException {      
         try(BufferedReader bufferedReader =new BufferedReader(new FileReader("archivos/usuarios.txt"))){
            String linea;
            while((linea=bufferedReader.readLine())!=null){
                System.out.println(linea);
                String []info = linea.split(";");
                if(info[0].equals(textUsuario.getText()) && info[1].equals(textPassword.getText())){
                    App.usuarioIniciado=textUsuario.getText();
                    String[] juegos=info[2].split(",");
                    for(int x=0;x<juegos.length;x++){
                        System.out.println(juegos[x]);
                        App.listaDeseos.addLast(juegos[x]);
                    }
                    bufferedReader.close();
                    App.inicioSesion=true;
                    App.setRoot("pruebaPrincipal"); 
                    return;
                }
            }
            texto.setText("Usuario o contraseña incorrectos");
        }catch (IOException ex) { 
            ex.printStackTrace();
        }

    }
    private void colocarImagenBoton() {
        URL regreso = getClass().getResource("/com/mycompany/prg9/imagenes/anterior.png");
        Image imgRegreso = new Image(regreso.toString(), 20, 20, false, true);
        btnRegresar.setGraphic(new ImageView(imgRegreso));
        
        
    }
    
}
