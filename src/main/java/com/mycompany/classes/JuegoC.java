/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import tdas.ArrayList;

/**
 *
 * @author César
 */
public class JuegoC implements Serializable{
    String nombre;
    String desarrollador;
    String fecha;
    String genero;
    String descripcion;
    static ArrayList<JuegoC> listaJ = new ArrayList<>();
    private static final long serialVersionUID = 9999;
    public JuegoC(String nombre) {
        this.nombre = nombre;
    }
    /*
    public JuegoC(String nombre, String desarrollador, String fecha,String genero ,String descripcion) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.fecha = fecha;
        this.genero=genero;
        this.descripcion = descripcion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }*/
    public JuegoC(JuegoC juegoProbar) {
        nombre = juegoProbar.nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public static ArrayList<JuegoC> getListaJ() {
        return listaJ;
    }

    public static void setListaJ(ArrayList<JuegoC> listaJ) {
        JuegoC.listaJ = listaJ;
    }

    @Override
    public boolean equals(Object obj) {
        JuegoC j = (JuegoC) obj;
        if (obj != null) {
            System.out.println("Entro a comparar");
            String nameComplete = this.toString();
            if (j.toString().equals(nameComplete)) {
                System.out.println("Juego fue igual");
                return true;
            } else {
                System.out.println("Juego NO FUE igual");
                return false;
            }
        } else {
            return false;
        }

    }
    public static ArrayList<JuegoC> lecturaJuego(){
        ArrayList<JuegoC> listaJuego=new ArrayList<>();
        try(BufferedReader bufferedReader =new BufferedReader(new FileReader("archivos/juegos.txt"))){
            String linea;
            while((linea=bufferedReader.readLine())!=null){
                String []info = linea.split(";");
                JuegoC juego = new JuegoC(info[0]);
                listaJuego.addLast(juego);
            }
        }catch (IOException ex) { 
            ex.printStackTrace();
        }
    
        return listaJuego;
    }
    public void escribirJuego(){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/juegos.txt",true))) {
            sb.append("\r\n");
            sb.append(this.nombre);
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void reescrituraJuego(){
        
        StringBuilder sb = new StringBuilder();
        
        for(JuegoC j:JuegoC.getListaJ()){
            sb.append(j.nombre);
            sb.append("\r\n");
        }    
            
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/juegos.txt"))) {
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    public String toString(){
        return nombre;
    }

}
