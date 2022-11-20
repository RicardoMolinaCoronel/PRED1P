/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes;

import com.mycompany.classes.Album;
import tdas.ArrayList;

/**
 *
 * @author César
 */
public class BibliotecaJuegos {
    private static ArrayList<Album> listaAlbumes=new ArrayList<>();
     private static Album albumSelec=new Album();

    public static ArrayList<Album> getListaAlbumes() {
        return listaAlbumes;
    }

    public static Album getAlbumSelec() {
        return albumSelec;
    }

    public static void setAlbumSelec(Album albumSelec) {
        BibliotecaJuegos.albumSelec = albumSelec;
    }
}
