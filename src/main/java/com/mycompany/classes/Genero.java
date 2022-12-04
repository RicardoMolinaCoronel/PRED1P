/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import tdas.*;
/**
 *
 * @author USER1
 */
public class Genero {
    
    public static ArrayList<String> cargarGeneros(){
        ArrayList<String> listaRetorno = new ArrayList<>();
        
        try(BufferedReader lector = new BufferedReader(new FileReader("archivos/generos.txt"))){
            String linea;
            
            while((linea = lector.readLine()) != null){
                
                listaRetorno.add(linea);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listaRetorno;
     }
 
    
}
