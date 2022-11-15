/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import tdas.ArrayList;

/**
 *
 * @author César
 */
public class BibliotecaJuegos {
    private static ArrayList<Juego> listaAlbumes=new ArrayList<>();
     private static Juego albumSelec=new Juego();

    public static ArrayList<Juego> getListaAlbumes() {
        return listaAlbumes;
    }

    public static Juego getAlbumSelec() {
        return albumSelec;
    }

    public static void setAlbumSelec(Juego albumSelec) {
        BibliotecaJuegos.albumSelec = albumSelec;
    }
}
