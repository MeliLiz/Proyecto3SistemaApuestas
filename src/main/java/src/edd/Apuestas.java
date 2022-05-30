
package src.edd;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.edd.Juego;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author meli
 */
public class Apuestas {

    public static void main(String[] args) {
        Juego juego=new Juego();
        File archivo = new File ("archivo.obj"); 
        try{
            archivo.createNewFile();
        }catch(IOException e){
            System.out.println("No se pudo crear el archivo");
        }
        
        System.out.println("Archivo");
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("archivo.obj"));
            juego=(Juego)entrada.readObject();
            entrada.close();
        }catch(Exception e){//Si el archivo no se pudo leer
            System.out.println("No se pudo deserializar");
        }
        LogIn VentanaIngresar=new LogIn(juego);
        VentanaIngresar.setVisible(true);
    }
}
