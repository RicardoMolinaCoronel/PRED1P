/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import tdas.*;
/**
 *
 * @author Ricardo
 */
public class Juego {
    private String titulo;
    private String fechaDeLanzamiento;
    private String genero;
    private String descripcion;
    private String desarrollador;
    ArrayList<Comentario> comentarios;
    public Juego(){}

    public Juego(String titulo, String fechaDeLanzamiento, String genero, String descripcion, String desarrollador, ArrayList<Comentario> comentarios) {
        this.titulo = titulo;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.genero = genero;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    public int promedio(){
        int prom = 0;
        int tam = 0;
        for(Comentario calf:comentarios){
            prom +=calf.getCalificacion();
            tam++;
        }
        prom = prom/tam;
        return prom;
    }
        public static ArrayList<Juego> lecturaJuegos() throws FileNotFoundException, IOException{
            ArrayList<Juego> listaJuego=new ArrayList<>();
            try(BufferedReader bufferedReader=new BufferedReader(new FileReader("archivo/juego.txt"))){
                String linea;
                int i = 0;
                while((linea=bufferedReader.readLine())!=null){
                    String[]info = linea.split("; ");
                    String []coments = linea.split(":");
                    String [] comenV = coments[2].split(";");
                    ArrayList<Comentario> comentarioA= new ArrayList<>();
                    for(String comF:comenV){
                        Comentario comen=new Comentario(Integer.valueOf(comenV[0]),comenV[1],comenV[2], comenV[3]);
                        comentarioA.add(comen);
                    }
                    
                    Juego juego = new Juego(info[0], info[1], info[2],info[3], info[4],comentarioA );
                    listaJuego.addLast(juego);
                    i++;
                }
            }
            return listaJuego;
        }
        public void escribirJuego(){
            StringBuilder sb = new StringBuilder();
            try(BufferedWriter bufferedW= new BufferedWriter(new FileWriter("archivo/juego.txt",true))){
                sb.append("\r\n");
                sb.append(this.titulo).append(",");
                sb.append(this.genero).append(","); 
                sb.append(this.descripcion).append(",");
                sb.append(this.desarrollador).append(",");
                sb.append(this.comentarios); 
                bufferedW.write(sb.toString());
                
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
        public static void reescrituraJuego(){
        
        StringBuilder sb = new StringBuilder();
        
        
        for(Juego a:BibliotecaJuegos.getListaAlbumes() ){
            
            if(BibliotecaJuegos.getListaAlbumes().indexOf(a)!=0){
            sb.append("\r\n");
            sb.append(a.titulo).append(",");
                sb.append(a.genero).append(","); 
                sb.append(a.descripcion).append(",");
                sb.append(a.desarrollador).append(",");
                sb.append(a.comentarios); 
            }
            
            
            
        }    
            
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/albumes.txt"))) {
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    
}
