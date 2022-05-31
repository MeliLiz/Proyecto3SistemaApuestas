
package src.edd;

import java.lang.Comparable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Clase que representa la sesion del jugador
 */
public class Jugador implements Comparable, Serializable{
    String nombreUsuario;
    Cuenta cuenta;
    String key;
    int numJugadorApostado;//torneo
    double cantidadApostada;//torneo
    double cuotaAp;//torneo
    int numJugadorApostadoCarrera;
    double cantidadApostadaCarrera;
    double cuotaApCarrera;

    /**
     * Costructor
     * @param nombre El nombre se usuario
     * @param key La contraseña de la cuenta
     */
    public Jugador(String nombre, String key){
        nombreUsuario=nombre;
        cuenta=new Cuenta();
        this.key=key;
    }//FIN DE CONSTRUCTOR



    /**
     * Metodo compareTo para comparar a los jugadores con base en su nombre de usuario
     * @param o
     * @return
     */
    @Override public int compareTo(Object o){
        if(!o.getClass().equals(this.getClass())){
            throw new IllegalArgumentException("Parametro no valido");
        }else{
            Jugador j=(Jugador)o;
            if(nombreUsuario.equals(j.nombreUsuario)){
                return 0;
            }
            if(nombreUsuario.compareTo(j.nombreUsuario)<0){
                return -1;
            }else{
                return 1;
            }
        }
    }//FIN DE COMPARE TO

    /**
     * Metodo equals basandose en el nombre de usuario
     */
    @Override public boolean equals(Object obj){
        if(!obj.getClass().equals(this.getClass())){
            return false;
        }else{
            Jugador j=(Jugador) obj;
            if(j.nombreUsuario.equals(this.nombreUsuario)){
                return true;
            }else{
                //System.out.println("else");
                return false;
            }
        }
    }//FIN DE EQUALS

    /**
     * ToString que regresa el nombre de usuario
     */
    public String toString(){
        return nombreUsuario;
    }//FIN DE TO STRING
}

