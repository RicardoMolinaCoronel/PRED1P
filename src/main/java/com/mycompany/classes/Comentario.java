/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import tdas.ArrayList;

/**
 *
 * @author Ricardo
 */
public class Comentario implements Serializable{
    private int calificacion;
    private String usuario;
    private String descripcion;
    private String fecha;
    private static final long serialVersionUID = 7845;
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Comentario( String usuario,int calificacion, String fecha,String descripcion) {
        this.calificacion = calificacion;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    @Override
    public boolean equals(Object obj) {
        Comentario j = (Comentario) obj;
        if (obj != null) {
            System.out.println("Entro a comparar");
            String nameComplete = this.toString();
            if (j.toString().equals(nameComplete)) {
                System.out.println("Comentario fue igual");
                return true;
            } else {
                System.out.println("Comentario NO FUE igual");
                return false;
            }
        } else {
            return false;
        }

    }
    public static ArrayList<Comentario> lecturaAlbum(String a){
        ArrayList<Comentario> listaComent=new ArrayList<>();
        
        try(BufferedReader bufferedReader =new BufferedReader(new FileReader("archivos/albumes/"+a+"/comentarios.txt"))){
            String linea;
            while((linea=bufferedReader.readLine())!=null){
                String []info = linea.split(";");
                Comentario coment = new Comentario(info[0],Integer.valueOf(info[1]),info[2],info[3]);
                listaComent.addLast(coment);
            }
        }catch (IOException ex) { 
            ex.printStackTrace();
        }
    
        return listaComent;
    }
    /*
    public void escribirJuego(){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/juegos.txt",true))) {
            sb.append("\r\n");
            sb.append(this.usuario);
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
        
    }*/
    
    public String toString(){
        return usuario;
    }

}