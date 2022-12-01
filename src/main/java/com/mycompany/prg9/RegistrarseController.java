/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prg9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class RegistrarseController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    TextField textUsuario;
    @FXML
    TextField textPassword;
    @FXML
    Text texto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("aa");
    }  
    @FXML
    private void regresar() throws IOException {
        App.setRoot("iniciarSesion");

    }
    @FXML
    private void registrarse() throws IOException {
        if(!(textUsuario.getText().equals("") || textPassword.getText().equals(""))){
         try(BufferedReader bufferedReader =new BufferedReader(new FileReader("archivos/usuarios.txt"))){
            String linea;
            while((linea=bufferedReader.readLine())!=null){
                System.out.println(linea);
                String []info = linea.split(";");
                if(info[0].equals(textUsuario.getText())){
                    bufferedReader.close();
                    texto.setText("Usuario existente");
                    return;
                }
            }
        }catch (IOException ex) { 
            ex.printStackTrace();
        }
        BufferedWriter bw = null;
		try {
			File fichero = new File("archivos/usuarios.txt");
			System.out.println(fichero.getCanonicalPath()); // Path completodonde se creará el fichero.
			bw = new BufferedWriter(new FileWriter(fichero,true));
			bw.newLine();
                        
                        bw.write(textUsuario.getText()+";"+textPassword.getText()+";,");
                        texto.setText("Usuario creado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close(); // Cerramos el buffer
			} catch (Exception e) {
			}
    }
        }else{
        texto.setText("Rellene todos los campos");
        }
}
}