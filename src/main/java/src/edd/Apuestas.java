
package src.edd;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.edd.Juego;
import java.io.File;
import java.io.IOException;

/**
 * Clase para que todo el programa inicie
 * @author meli
 */
public class Apuestas {

    static Juego juego;//El juego con el que trabajaremos
    
    /**
     * Metodo principal
     * @param args 
     */
    public static void main(String[] args) {
        Juego j=new Juego();//Hacemos un nuevo juego
        juego=j;//lo asignamos a la variable de la clase (solo por si el archivo no tiene datos)
        
        //Tratamos de leer el archivo
        File archivo = new File ("archivo.obj"); 
        if(archivo.exists()){
            if(!archivo.canRead()){
                throw new RuntimeException("No es posible abrir el archivo ");
            }
            if(!archivo.canWrite()){
                throw new RuntimeException("No es posible escribir en el archivo ");
            }
            leerArchivo();
        }
        
        System.out.println("Archivo");
       
        //Abrimos la ventana para ingresar
        LogIn VentanaIngresar=new LogIn(juego);
        VentanaIngresar.setVisible(true);
    }
    
    /**
     * Metodo para leer el archivo obj
     */
    public static void leerArchivo(){
        ObjectInputStream lector=null;//Hacemos un lector
        try{//tratamos de leer el archivo
            lector=new ObjectInputStream(new FileInputStream("archivo.obj"));
            Object objeto;
            do{//leemos los objetos del archivo
                objeto=lector.readObject();
                if(objeto!=null){
                    juego=(Juego)objeto;
                }
            }while(objeto!=null);
        }catch(java.lang.ClassNotFoundException e){
        }catch(java.io.EOFException e){
            System.out.println("Fin del archivo");
        }catch(IOException e){
            System.out.println("Lectura fallida: "+e);
        }finally{//cerramos el archivo
            if(lector!=null){
                System.out.println("Cerrando el archivo");
                try{
                    lector.close();
                }catch(IOException e){}
            }else{
                System.out.println("No se abrió ningun archivo");
            }
        }
    }
}
